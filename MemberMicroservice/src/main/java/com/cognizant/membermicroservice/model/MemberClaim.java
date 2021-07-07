package com.cognizant.membermicroservice.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="member_claim")
@Getter
@Setter
@NoArgsConstructor
@Component
public class MemberClaim {

	@Id
	private int claimId;
	private int policyId;
	private int memberId;
	private int providerId;
	private int benefitId;
	private double totalBilledAmount;
	private double totalClaimedAmount;
	private String claimStatus;
	private String claimDescription;
	public int getPolicyId() {
		// TODO Auto-generated method stub
		return 0;
	}
	public int getClaimId() {
		// TODO Auto-generated method stub
		return 0;
	}
	public Object getClaimDescription() {
		// TODO Auto-generated method stub
		return null;
	}
	public Object getClaimStatus() {
		// TODO Auto-generated method stub
		return null;
	}
	public int getMemberId() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	
}
