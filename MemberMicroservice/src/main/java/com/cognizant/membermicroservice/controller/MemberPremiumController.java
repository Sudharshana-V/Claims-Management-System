package com.cognizant.membermicroservice.controller;



import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.cognizant.membermicroservice.dto.ClaimStatusDTO;
import com.cognizant.membermicroservice.model.MemberClaim;
import com.cognizant.membermicroservice.model.MemberPremium;
import com.cognizant.membermicroservice.repository.ClaimRepository;
import com.cognizant.membermicroservice.repository.PremiumRepository;
import com.cognizant.membermicroservice.service.ClaimService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import com.cognizant.membermicroservice.client.ClaimsClient;
import org.springframework.http.HttpStatus;

@RestController
public class MemberPremiumController {

	@Autowired
	PremiumRepository premiumRepo;

	@Autowired
	ClaimRepository claimRepo;

	@Autowired
	ClaimService claimserviceimpl;
	
	@Autowired
	ClaimsClient claimsClient;
	
	@Autowired
	ClaimService claimservice;
	
	@Autowired
	RestTemplate resttemp;
	
	Logger logger = LoggerFactory.getLogger(this.getClass());	

	/*This RESTENDPOINT  is used to view the details of the Bills*/
	//@RequestMapping("billDetails/{policyid}")
	@GetMapping("billDetails/{policyid}")
   public List<MemberPremium> billDetails(@PathVariable("policyid")int policyid)
   {
		logger.trace("Inside billDetails()");
		return premiumRepo.findBypolicyId(policyid);
	   
   }
	
	/*This RESTENDPOINT  is used to view Bills*/
	//@RequestMapping("/viewBills/memberid/{memberid}/policyid/{policyid}")
	@GetMapping("/viewBills/{memberid}/{policyid}")
	public ResponseEntity<MemberPremium> bill(@PathVariable Integer memberid,@PathVariable Integer policyid)
	{
		
		logger.trace("Inside viewBills()");
		List<MemberPremium>forpolicy=premiumRepo.findBypolicyId(policyid);
		List<MemberPremium>formember=premiumRepo.findBymemberId(memberid);
		
		
		
		for(MemberPremium m:formember)
		{
			Integer mem=m.getMemberId();
			for(MemberPremium m1:forpolicy)
			{
				if(mem.equals(m1.getMemberId()))
				{
				
					return new ResponseEntity<>(m1,HttpStatus.OK);			
					
				}
			}					
			
		}
		return null;	
		
	}		
	
	/*This RESTENDPOINT  is used to view the status of the claim already submitted*/
	@GetMapping(value = "/getClaimStatus/{claimid}/{policyid}/{memberid}")
	public ResponseEntity<ClaimStatusDTO> getClaimStatus(@PathVariable int claimid,@PathVariable int policyid,@PathVariable int memberid) 
		{	
		
			ClaimStatusDTO obj = resttemp.getForObject("http://localhost:8090/claims/getClaimStatus/"+claimid+"/"+policyid+"/"+memberid,ClaimStatusDTO.class);	
			System.out.println(obj);
			return new ResponseEntity<>(obj,HttpStatus.OK);
		}

	
	/*This RESTENDPOINT  is used to submit a new claim*/
	@PostMapping(value = "/submitClaim")
	public ResponseEntity<MemberClaim> submitClaim( @RequestBody MemberClaim claim) {
		System.out.println(claim);
		RestTemplate rt = new RestTemplate();
	

		MemberClaim postForObject = rt.postForObject("http://localhost:8090/claims/submitClaim", claim,
				MemberClaim.class);
		return new ResponseEntity<>(postForObject,HttpStatus.OK);
	}
	@Bean
	public RestTemplate restTemplate() {
	    return new RestTemplate();
	}

}