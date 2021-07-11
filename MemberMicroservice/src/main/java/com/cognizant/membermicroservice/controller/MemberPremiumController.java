package com.cognizant.membermicroservice.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.membermicroservice.dto.ClaimStatusDTO;
import com.cognizant.membermicroservice.model.MemberPremium;
import com.cognizant.membermicroservice.repository.ClaimRepository;
import com.cognizant.membermicroservice.repository.PremiumRepository;
import com.cognizant.membermicroservice.service.ClaimService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import feign.FeignException;
import org.springframework.http.ResponseEntity;
import com.cognizant.membermicroservice.client.ClaimsClient;
import org.springframework.http.MediaType;

@RestController
public class MemberPremiumController {

	@Autowired
	PremiumRepository premiumRepo;

	@Autowired
	ClaimRepository claimRepo;

	@Autowired
	ClaimService claimserviceimpl;
	
	private ClaimsClient claimsClient;
	
	Logger logger = LoggerFactory.getLogger(this.getClass());

	
	
	
	
	/*@GetMapping(value = "/billDetails/{policyId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> billDetails(@PathVariable("policyId") int policyId) {

		return new ResponseEntity<>(premiumRepo.findBypolicyId(policyId), HttpStatus.OK);

	}*/

	/*@GetMapping(value = "/viewBills/{memberId}")
	public List<MemberPremium> viewBills(@PathVariable(value = "memberId") int memberId ) {
		//return (List<MemberPremium>) claimserviceimpl.viewBills(memberId,policyId);
		return premiumRepo.findBymemberId(memberId);
	}*/
	
	/*@GetMapping(value = "/viewBills/{memberId}/{policyId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> viewBills(@PathVariable Integer memberId, @PathVariable Integer policyId){
	return new ResponseEntity<ViewBillsDTO>(claimserviceimpl.viewBills(memberId, policyId), HttpStatus.OK);
	}*/
	
	//@RequestMapping("billDetails/{policyid}")
	@GetMapping("billDetails/{policyid}")
   public List<MemberPremium> billDetails(@PathVariable("policyid")int policyid)
   {
		logger.trace("Inside billDetails()");
		return premiumRepo.findBypolicyId(policyid);
	   
   }
	
	//@RequestMapping("/viewBills/memberid/{memberid}/policyid/{policyid}")
	@GetMapping("/viewBills/memberid/{memberid}/policyid/{policyid}")
	public List<MemberPremium> bill(@PathVariable Integer memberid,@PathVariable Integer policyid)
	{
		
		logger.trace("Inside viewBills()");
		List<MemberPremium>forpolicy=premiumRepo.findBypolicyId(policyid);
		List<MemberPremium>formember=premiumRepo.findBymemberId(memberid);
		
		List<MemberPremium>newer=new ArrayList<MemberPremium>();
		
		for(MemberPremium m:formember)
		{
			Integer mem=m.getMemberId();
			for(MemberPremium m1:forpolicy)
			{
				if(mem.equals(m1.getMemberId()))
				{
					newer.add(m1);
				}
			}
			
			
		}
		return newer;
		
		
	}
	
	
	@GetMapping(value = "/getClaimStatus/claimid/{claimid}/policyid/{policyid}/memberid/{memberid}")
	public ClaimStatusDTO getClaimStatus(@PathVariable Integer claimid,@PathVariable Integer policyid,@PathVariable Integer memberid) {
		
		

		ClaimStatusDTO claimStatus =  claimsClient.getClaimStatus(claimid, policyid, memberid);
		
		return claimStatus;

	}

	
	
	/*@GetMapping(value = "/getClaimStatus/{claimId}/{policyId}/{memberId}")
	public List<ClaimStatusDTO> getclaimStatus(@PathVariable int claimId, @PathVariable int policyId,
			@PathVariable int memberId) {
		
		List<ClaimStatusDTO> claimStatus = claimsClient.getClaimStatus(claimId, policyId, memberId);
		return claimStatus;
		//return "No claim Status";
	}
			*/	

		
		

	

	@PostMapping("/submitClaim/{policyId}")
	public  String submitClaim(@PathVariable int policyId) {
				logger.trace("Inside submitClaim()"); 
				return "claim submitted";
		
		

	}

}