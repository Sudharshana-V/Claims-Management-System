package com.cognizant.claimsmicroservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.claimsmicroservice.client.PolicyClient;
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
	
	@Autowired
	PolicyClient policyClient;
	

	@Override
	public ClaimStatusDTO getClaimStatus(int claimid, int policyid, int memberid) throws ProviderNotFoundException {
		
		Claim claim = claimRepo.getById(claimid);
		

		
		
		if (claim.getPolicyId() == policyid && claim.getMemberId() == memberid) {
			claimDto.setClaimStatus(claim.getClaimStatus());
			claimDto.setDescription(claim.getDescription());
			
		}
		else {
			throw new ProviderNotFoundException("provider not found");
		}
		
		return claimDto;
	
	}
	@Override
	public ClaimStatusDTO processSubmitClaim(int policyId, int claimId, int memberId, int providerId, int benefitId,
			double totalAmount, double claimedAmount) throws ProviderNotFoundException, BenefitsNotFoundException {
		Claim claimObj = null;
		 List<ProviderPolicy> chainOfProviders = policyClient.getChainOfProviders(policyId);
	
		 List<Benefits> eligibleBenefits = policyClient.getEligibleBenefits(policyId, memberId);
		double eligibleClaimAmount = policyClient.getClaimAmount(policyId, memberId, benefitId);
		

		if (claimedAmount <= eligibleClaimAmount) {

			if (claimedAmount > totalAmount) {
				claimObj = new Claim(claimId, "Under Dispute",
						"Claim Amount cannot be settled more than its actually required", policyId, memberId,
						benefitId, providerId, claimedAmount, 0);
				claimRepo.save(claimObj);
				claimDto.setClaimStatus(claimObj.getClaimStatus());
				claimDto.setDescription(claimObj.getDescription());
			} else {
				
				ProviderPolicy providers = chainOfProviders.stream().filter(p -> p.getProviderId() == providerId)
						.findFirst().orElseThrow(()->new ProviderNotFoundException("provider not found"));

				Benefits benefits = eligibleBenefits.stream().filter(b -> b.getBenefitId() == benefitId).findFirst()
						.orElseThrow(()->new BenefitsNotFoundException("benefit not found"));
				
				
				claimObj = new Claim(claimId, "Pending Action",
						"claim has been submitted! Please check after few days for confirmation", policyId,
						memberId, benefitId, providerId, claimedAmount, claimedAmount);
					claimRepo.save(claimObj);
					claimDto.setClaimStatus(claimObj.getClaimStatus());
					claimDto.setDescription(claimObj.getDescription());

				}
			
		} else {
			claimObj = new Claim(claimId, "Claim Rejected", "Claim Amount is greater than the eligible claim Amount",
					policyId, memberId, benefitId, providerId, claimedAmount, 0);
			claimRepo.save(claimObj);
			claimDto.setClaimStatus(claimObj.getClaimStatus());
			claimDto.setDescription(claimObj.getDescription());
		}

		return claimDto;
	}


	
	
	
	
}
