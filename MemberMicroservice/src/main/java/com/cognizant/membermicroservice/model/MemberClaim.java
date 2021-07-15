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
	public MemberClaim(){
	}
	
	public MemberClaim(int claimId, int policyId, int memberId, int providerId, int benefitId, double totalBilledAmount,
			double totalClaimedAmount, String claimStatus, String claimDescription) {
		super();
		this.claimId = claimId;
		this.policyId = policyId;
		this.memberId = memberId;
		this.providerId = providerId;
		this.benefitId = benefitId;
		this.totalBilledAmount = totalBilledAmount;
		this.totalClaimedAmount = totalClaimedAmount;
		this.claimStatus = claimStatus;
		this.claimDescription = claimDescription;
	}
	public int getClaimId() {
		return claimId;
	}
	public void setClaimId(int claimId) {
		this.claimId = claimId;
	}
	public int getPolicyId() {
		return policyId;
	}
	public void setPolicyId(int policyId) {
		this.policyId = policyId;
	}
	public int getMemberId() {
		return memberId;
	}
	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}
	public int getProviderId() {
		return providerId;
	}
	public void setProviderId(int providerId) {
		this.providerId = providerId;
	}
	public int getBenefitId() {
		return benefitId;
	}
	public void setBenefitId(int benefitId) {
		this.benefitId = benefitId;
	}
	public double getTotalBilledAmount() {
		return totalBilledAmount;
	}
	public void setTotalBilledAmount(double totalBilledAmount) {
		this.totalBilledAmount = totalBilledAmount;
	}
	public double getTotalClaimedAmount() {
		return totalClaimedAmount;
	}
	public void setTotalClaimedAmount(double totalClaimedAmount) {
		this.totalClaimedAmount = totalClaimedAmount;
	}
	public String getClaimStatus() {
		return claimStatus;
	}
	public void setClaimStatus(String claimStatus) {
		this.claimStatus = claimStatus;
	}
	public String getClaimDescription() {
		return claimDescription;
	}
	public void setClaimDescription(String claimDescription) {
		this.claimDescription = claimDescription;
	}
	
	
	
	
}
