package com.cognizant.membermicroservice.service;



import com.cognizant.membermicroservice.dto.ViewBillsDTO;
import com.cognizant.membermicroservice.model.MemberClaim;


public interface ClaimService {	
	
	public ViewBillsDTO viewBills(int memberId,int policyId);
	public MemberClaim saveClaim(MemberClaim memberSubmitClaim) ;
}
