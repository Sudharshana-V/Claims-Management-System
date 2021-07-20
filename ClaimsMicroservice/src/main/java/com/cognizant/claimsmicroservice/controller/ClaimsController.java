package com.cognizant.claimsmicroservice.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.cognizant.claimsmicroservice.client.PolicyClient;
import com.cognizant.claimsmicroservice.dto.ClaimStatusDTO;
import com.cognizant.claimsmicroservice.exception.BenefitsNotFoundException;
import com.cognizant.claimsmicroservice.exception.ProviderNotFoundException;
import com.cognizant.claimsmicroservice.model.Benefits;
import com.cognizant.claimsmicroservice.model.Claim;
import com.cognizant.claimsmicroservice.model.ProviderPolicy;
import com.cognizant.claimsmicroservice.repository.ClaimRepository;

import com.cognizant.claimsmicroservice.service.ClaimServiceImpl;



import lombok.extern.slf4j.Slf4j;


@Slf4j
@RestController
public class ClaimsController {

	@Autowired
	ClaimServiceImpl claimserviceImpl;


	@Autowired
	ClaimStatusDTO claimsDto;

	@Autowired
	ClaimRepository claimrepo;
	
	@Autowired
	PolicyClient policyClient;
	
	@Autowired
	RestTemplate resttemp;
	
	/*This RESTENDPOINT  is used to view the status of the claim already submitted*/
	
	@GetMapping(value = "/getClaimStatus/{claimid}/{policyid}/{memberid}")
	public ClaimStatusDTO getClaimStatus(@PathVariable int claimid,@PathVariable int policyid,@PathVariable int memberid) throws ProviderNotFoundException
	{
				//return claimrepo.findByclaimId(claimid);
				return claimserviceImpl.getClaimStatus(claimid, policyid, memberid);
		
	}
	
	
	
	

	
	/*This RESTENDPOINT  is used to submit a new claim*/
	@PostMapping(value = "/submitClaim")
	public Claim submitClaim(@RequestBody Claim claim) {
	
		claimserviceImpl.saveClaim(claim);
		
		System.out.println(claim);
		RestTemplate rt = new RestTemplate();
		ResponseEntity<Integer> forEntity  = resttemp.getForEntity("http://localhost:8080/policy/getClaimAmount/"+claim.getPolicyId()+"/"+claim.getMemberId()+"/"+claim.getBenefitId(),Integer.class);
		int eligibleClaimAmount = forEntity.getBody();
		System.out.println(eligibleClaimAmount);
		System.out.println(claim.getAmountClaimed());
		//ResponseEntity<Benefits> benefits  = resttemp.getForEntity("http://localhost:8080/policy/getEligibleBenefits/"+claim.getPolicyId()+"/"+claim.getMemberId(),Benefits.class);
		
		
		double claimedAmount =claim.getAmountClaimed();
		String result;
		if(eligibleClaimAmount >= claimedAmount) {
			result = "Pending Action";
			 
			
		}
		
		
		
		
		else {
				result = "claim rejected";
			}
			
		//Claim dtoobj = new Claim();
		
		claim.setClaimStatus(result);
		/*claim.setPolicyId(claim.getPolicyId());
		claim.setMemberId(claim.getMemberId());
		claim.setProviderId(claim.getProviderId());
		claim.setClaimId(claim.getClaimId());
		claim.setBenefitId(claim.getBenefitId());
		claim.setAmountClaimed(claimedAmount);
		claim.setAmountSettled(claim.getAmountSettled());*/
		//claim.setDescription("Null");
		
		
		claimserviceImpl.saveClaim(claim);
		//return claim;*/
		System.out.println(claim);
		return claim;
		
		
	/*	HashMap<String, Integer> uriVariables = new HashMap<>();
		uriVariables.put("policyId", claim.getPolicyId());
		uriVariables.put("memberId", claim.getMemberId());
		uriVariables.put("benefitId", claim.getBenefitId());
	
		RestTemplate rt = new RestTemplate();
		ResponseEntity<Integer> forEntity = rt.getForEntity("http://localhost:8080/policy/getClaimAmount/{policyId}/{memberId}/{benefitId}", Integer.class, uriVariables);
		int eligibleClaimAmount = forEntity.getBody();
		
		HashMap<String, Integer> uriVariables1 = new HashMap<>();
		uriVariables1.put("policyId", claim.getPolicyId());
		ResponseEntity<ProviderPolicy[]> forEntity2 = rt.getForEntity("http://localhost:8080/policy/getChainOfProviders/{policyId}", ProviderPolicy[].class, uriVariables1);
		ProviderPolicy[] body = forEntity2.getBody();
		
		
		//int hospitalId  = claim.getHospitalId();
		
	//	HashMap<String, Integer> uriVariables2 = new HashMap<>();
		//uriVariables2.put("id", hospitalId);
		
		HashMap<String, Integer> uriVariables2 = new HashMap<>();
		uriVariables2.put("policyId", claim.getPolicyId());
		uriVariables2.put("memberId", claim.getMemberId());
		ResponseEntity<ProviderPolicy> forEntity3 = rt.getForEntity("http://localhost:8080/getEligibleBenefits/{policyId}/{memberId}", ProviderPolicy.class, uriVariables2);
		ProviderPolicy eligibleBenefits = forEntity3.getBody();
		
		
		
	
		double claimedAmount =claim.getAmountClaimed();
		String result;
		if(eligibleClaimAmount >= claimedAmount) {
			result = "Claim Rejected";
			 
			
		}
		
		
		else if(claimedAmount < 0) {
			result = "Insufficient Claim details";
		}
		
		else {
				result = "Pending Action,claim has been submitted! Please check after few days for confirmation";
			}
			
		
		
		claim.setClaimStatus(result);
		claim.setPolicyId(claim.getPolicyId());
		claim.setMemberId(claim.getMemberId());
		claim.setProviderId(claim.getProviderId());
		claim.setClaimId(claim.getClaimId());
		claim.setBenefitId(claim.getBenefitId());
		claim.setAmountClaimed(claimedAmount);
		claim.setAmountSettled(claim.getAmountSettled());
		claim.setDescription("Null");
		
		
		claimserviceImpl.saveClaim(claim);
		//return claim;*/
	//	System.out.println(claim);
	//	return claim;
		
	}
	
	
	@Bean
	public RestTemplate restTemplate() {
	    return new RestTemplate();
	}
	
	
	

	
}


