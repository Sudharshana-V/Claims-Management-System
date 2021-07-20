package com.cognizant.memberportal.model;

public class MemberSubmitclaim {
	private int claimId;
	public MemberSubmitclaim(int claimId, int policyId, int memberId, int providerId, int benefitId,
			double totalBilledAmount, double totalClaimedAmount) {
		this.claimId = claimId;
		this.policyId = policyId;
		this.memberId = memberId;
		this.providerId = providerId;
		this.benefitId = benefitId;
		this.totalBilledAmount = totalBilledAmount;
		this.totalClaimedAmount = totalClaimedAmount;
	}
	private int policyId;
	private int memberId;
	private int providerId;
	private int benefitId;
	private double totalBilledAmount;
	private double totalClaimedAmount;
	
	public int getClaimId() {
		return claimId;
	}
	public void setClaimId(int claimId) {
		this.claimId = claimId;
	}
	public MemberSubmitclaim() {
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

}
