package com.cognizant.membermicroservice.service;


//import com.cognizant.membermicroservice.dto.SubmitStatusDTO;
import com.cognizant.membermicroservice.dto.ViewBillsDTO;

public interface ClaimService {
	
	
	public ViewBillsDTO viewBills(int memberId,int policyId);

	//public ClaimStatusDTO getClaimStatus(int claimId, int policyId, int memberId);

	
}
