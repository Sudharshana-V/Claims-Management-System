package com.cognizant.claimsmicroservice.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.cognizant.claimsmicroservice.dto.ClaimStatusDTO;
import com.cognizant.claimsmicroservice.exception.BenefitsNotFoundException;
import com.cognizant.claimsmicroservice.exception.ProviderNotFoundException;

@Service
@Component
public interface ClaimService {

	public ClaimStatusDTO getClaimStatus(int claimid, int policyid, int memberid) throws ProviderNotFoundException;
	
	public ClaimStatusDTO processSubmitClaim(int policyId,
			 int claimId,
			 int memberId,
			 int providerId,
			 int benefitId,
			 double totalAmount,
			 double claimedAmount)throws ProviderNotFoundException,BenefitsNotFoundException;
	
}