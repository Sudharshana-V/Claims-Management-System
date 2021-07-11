package com.cognizant.membermicroservice.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import com.cognizant.membermicroservice.dto.ClaimStatusDTO;


@Component
@FeignClient(name = "claims-microservice", url = "http://localhost:8090/claims")
public interface ClaimsClient {

	@GetMapping("/getClaimStatus/claimid/{claimid}/policyid/{policyid}/memberid/{memberid}")
	public ClaimStatusDTO getClaimStatus(@PathVariable Integer claimid,@PathVariable Integer policyid,@PathVariable Integer memberid);
			
	
	@PostMapping("/submitClaim/{policyId}/{claimId}/{memberId}/{providerId}/{benefitId}/{totalAmount}/{claimedAmount}")
	public ResponseEntity<ClaimStatusDTO> submitClaim(@PathVariable int policyId, @PathVariable int claimId,
			@PathVariable int memberId, @PathVariable int providerId, @PathVariable int benefitId,
			@PathVariable double totalAmount, @PathVariable double claimedAmount,
			@RequestHeader(name = "Authorization", required = true) String token);

}