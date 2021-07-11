package com.cognizant.claimsmicroservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.cognizant.claimsmicroservice.dto.ClaimStatusDTO;
import com.cognizant.claimsmicroservice.exception.BenefitsNotFoundException;
import com.cognizant.claimsmicroservice.exception.ProviderNotFoundException;
import com.cognizant.claimsmicroservice.model.Benefits;
import com.cognizant.claimsmicroservice.model.Claim;
import com.cognizant.claimsmicroservice.model.ProviderPolicy;
import com.cognizant.claimsmicroservice.repository.ClaimRepository;

import lombok.extern.slf4j.Slf4j;



@Slf4j
@Service
public class ClaimServiceImpl implements ClaimService {

	@Autowired
	ClaimRepository claimRepo;

	@Autowired
	ClaimStatusDTO claimDto;

	

	@Override
	public ClaimStatusDTO getClaimStatus(int claimId, int policyId, int memberId) throws ProviderNotFoundException {
		
		Claim claim = claimRepo.getById(claimId);
		

		
		
		if (claim.getPolicyId() == policyId && claim.getMemberId() == memberId) {
			claimDto.setClaimStatus(claim.getClaimStatus());
			claimDto.setDescription(claim.getDescription());
			
		}
		else {
			throw new ProviderNotFoundException("provider not found");
		}
		
		return claimDto;
	
	}

	
	
	
}
