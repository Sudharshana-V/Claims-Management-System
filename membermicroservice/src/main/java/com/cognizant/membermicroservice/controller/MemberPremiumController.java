package com.cognizant.membermicroservice.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberPremiumController {
	
	
	
	@GetMapping(value = "/viewBills/{memberId}/{policyId}")
	public String viewBills(@PathVariable Integer memberId, @PathVariable Integer policyId)  
	
	{
		return "view bills page";
		
	}
	
	
	@GetMapping(value = "/getClaimStatus/{claimId}/{policyId}/{memberId}")
	public ResponseEntity<?> getClaimStatus(@PathVariable int claimId, @PathVariable int policyId,
			@PathVariable int memberId) 
	{
		return null;
	}
	
	@PostMapping("/submitClaim/{policyId}/{claimId}/{memberId}/{providerId}/{benefitId}/{totalAmount}/{claimedAmount}")
	public ResponseEntity<?> submitClaim(@PathVariable int policyId, @PathVariable int claimId,
			@PathVariable int memberId, @PathVariable int providerId, @PathVariable int benefitId,
			@PathVariable double totalAmount, @PathVariable double claimedAmount)
	
	{
		return null;
	}
}