package com.cognizant.claimsmicroservice.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	
	@GetMapping(value = "/getClaimStatus/claimid/{claimid}/policyid/{policyid}/memberid/{memberid}")
	public ClaimStatusDTO getClaimStatus(@PathVariable int claimid,@PathVariable int policyid,@PathVariable int memberid) throws ProviderNotFoundException
	{
				//return claimrepo.findByclaimId(claimid);
				return claimserviceImpl.getClaimStatus(claimid, policyid, memberid);
		
	}
	
		/*return new ResponseEntity<ClaimStatusDTO>(claimserviceImpl.getClaimStatus(claimId, policyId, memberId),
				HttpStatus.OK);*/
	
	
	

	/*@PostMapping(value = "/submitClaim/{policyId}/{claimId}/{memberId}/{providerId}/{benefitId}/{totalAmount}/{claimedAmount}")
	public ClaimStatusDTO submitClaim(@PathVariable Integer policyid, @PathVariable Integer claimid,
			@PathVariable Integer memberid, @PathVariable Integer providerid, @PathVariable Integer benefitid,
			@PathVariable Double totalamount, @PathVariable Double claimedamount) throws ProviderNotFoundException, BenefitsNotFoundException {
		
		
		return ClaimStatusDTO(claimsDto);
	}*/
	
	/*@PostMapping(value = "/submitClaim/{policyId}/{claimId}/{memberId}/{providerId}/{benefitId}/{totalAmount}/{claimedAmount}")
	public ClaimStatusDTO submitClaim(@PathVariable int policyId, @PathVariable int claimId,
			@PathVariable int memberId, @PathVariable int providerId, @PathVariable int benefitId,
			@PathVariable double totalAmount, @PathVariable double claimedAmount) throws ProviderNotFoundException, BenefitsNotFoundException {
		
			
			claimsDto = claimserviceImpl.processSubmitClaim(policyId, claimId, memberId, providerId, benefitId, totalAmount,
					claimedAmount);

		
		return claimsDto;
	}*/
	@PostMapping(value = "/submitClaim/{policyId}/{claimId}/{memberId}/{providerId}/{benefitId}/{totalAmount}/{claimedAmount}")
	public ResponseEntity<Claim> submitClaim(@RequestBody Claim claim,@PathVariable int policyId, @PathVariable int claimId,
			@PathVariable int memberId, @PathVariable int providerId, @PathVariable int benefitId,
			@PathVariable double totalAmount, @PathVariable double claimedAmount) {
	
			
		
		HashMap<String, Integer> uriVariables = new HashMap<>();
		uriVariables.put("policyId", policyId);
		uriVariables.put("memberId", memberId);
		uriVariables.put("benefitId", benefitId);
		
		RestTemplate rt = new RestTemplate();
		ResponseEntity<Integer> forEntity = rt.getForEntity("http://localhost:8080/policy/getClaimAmount/{policyId}/{memberId}/{benefitId}", Integer.class, uriVariables);
		int eligibleClaimAmount = forEntity.getBody();
		
		HashMap<String, Integer> uriVariables1 = new HashMap<>();
		uriVariables1.put("policyId", policyId);
		ResponseEntity<ProviderPolicy[]> forEntity2 = rt.getForEntity("http://localhost:8080/policy/getChainOfProviders/{policyId}", ProviderPolicy[].class, uriVariables1);
		ProviderPolicy[] body = forEntity2.getBody();
		
		
		//int hospitalId  = claim.getHospitalId();
		
	//	HashMap<String, Integer> uriVariables2 = new HashMap<>();
		//uriVariables2.put("id", hospitalId);
		
		HashMap<String, Integer> uriVariables2 = new HashMap<>();
		uriVariables2.put("policyId", policyId);
		uriVariables2.put("memberId", memberId);
		ResponseEntity<ProviderPolicy> forEntity3 = rt.getForEntity("http://localhost:8080getEligibleBenefits/{policyId}/{memberId}", ProviderPolicy.class, uriVariables2);
		ProviderPolicy eligibleBenefits = forEntity3.getBody();
		
		
		
	
		
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
		claim.setPolicyId(policyId);
		claim.setMemberId(memberId);
		claim.setProviderId(providerId);
		claim.setClaimId(claimId);
		claim.setBenefitId(benefitId);
		claim.setAmountClaimed(claimedAmount);
		claim.setAmountSettled(totalAmount);
		claim.setDescription("Null");
		
		
		claimserviceImpl.saveClaim(claim);
		//return claim;
		return new ResponseEntity<Claim>(claim, HttpStatus.OK);
		
	}
	
	
		
	
	
	

	
}


