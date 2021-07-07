package com.cognizant.membermicroservice.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.cognizant.membermicroservice.dto.ClaimStatusDTO;
import com.cognizant.membermicroservice.dto.ViewBillsDTO;
import com.cognizant.membermicroservice.model.MemberPolicy;
import com.cognizant.membermicroservice.model.MemberPremium;
import com.cognizant.membermicroservice.repository.ClaimRepository;
import com.cognizant.membermicroservice.repository.PremiumRepository;
import com.cognizant.membermicroservice.service.ClaimService;
import feign.FeignException;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;


@Api(value = "Member Premium Controller")

@RestController
public class MemberPremiumController {

	@Autowired
	PremiumRepository premiumRepo;

	@Autowired
	ClaimRepository claimRepo;

	@Autowired
	ClaimService claimserviceimpl;

	

	
	
	
	
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
	
	@RequestMapping("billDetails/{policyid}")
	@GetMapping()
   public List<MemberPremium> billDetails(@PathVariable("policyid")int policyid)
   {
	   
	return premiumRepo.findBypolicyId(policyid);
	   
   }
	
	@RequestMapping("/viewBills/memberid/{memberid}/policyid/{policyid}")
	@GetMapping()
	public List<MemberPremium> bill(@PathVariable Integer memberid,@PathVariable Integer policyid)
	{
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
	
	
	@GetMapping(value = "/getclaimStatus/{policyId}")
	public String getclaimStatus(@PathVariable(value = "policyId") int policyId ) {
		
		return "No claim Status";
	}
				

		
		

	

	@PostMapping("/submitClaim/{policyId}")
	public  String submitClaim(@PathVariable int policyId) {
				return "claim submitted";
		
		//return claimsClient.submitClaim(policyId, claimId, memberId, providerId, benefitId, totalAmount, claimedAmount,
				//token);

	}

}