package com.cognizant.claimsmicroservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RestController;


import com.cognizant.claimsmicroservice.dto.ClaimStatusDTO;
import com.cognizant.claimsmicroservice.exception.BenefitsNotFoundException;
import com.cognizant.claimsmicroservice.exception.ProviderNotFoundException;

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
	
	
	
	
	@GetMapping(value = "/getClaimStatus/claimid/{claimid}/policyid/{policyid}/memberid/{memberid}")
	public ClaimStatusDTO getClaimStatus(@PathVariable Integer claimid,@PathVariable Integer policyid,@PathVariable Integer memberid) throws ProviderNotFoundException
	{
				//return claimrepo.findByclaimId(claimid);
				return claimserviceImpl.getClaimStatus(claimid, policyid, memberid);
		
	}
	
		/*return new ResponseEntity<ClaimStatusDTO>(claimserviceImpl.getClaimStatus(claimId, policyId, memberId),
				HttpStatus.OK);*/
	
	
	

	@PostMapping(value = "/submitClaim/{policyId}/{claimId}/{memberId}/{providerId}/{benefitId}/{totalAmount}/{claimedAmount}")
	public ResponseEntity<?> submitClaim(@PathVariable int policyId, @PathVariable int claimId,
			@PathVariable int memberId, @PathVariable int providerId, @PathVariable int benefitId,
			@PathVariable double totalAmount, @PathVariable double claimedAmount) throws ProviderNotFoundException, BenefitsNotFoundException {
		
		
		return new ResponseEntity<ClaimStatusDTO>(claimsDto, HttpStatus.OK);
	}
}


