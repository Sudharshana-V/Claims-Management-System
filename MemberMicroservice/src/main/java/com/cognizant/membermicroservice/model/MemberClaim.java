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
	private double amountClaimed;
	private double amountSettled;
	private String claimStatus;
	private String description;
	public MemberClaim(){
	}
	@Override
	public String toString() {
		return "MemberClaim [claimId=" + claimId + ", policyId=" + policyId + ", memberId=" + memberId + ", providerId="
				+ providerId + ", benefitId=" + benefitId + ", amountClaimed=" + amountClaimed + ", amountSettled="
				+ amountSettled + ", claimStatus=" + claimStatus + ", description=" + description + "]";
	}
	public MemberClaim(int claimId, int policyId, int memberId, int providerId, int benefitId, double amountClaimed,
			double amountSettled, String claimStatus, String description) {
		this.claimId = claimId;
		this.policyId = policyId;
		this.memberId = memberId;
		this.providerId = providerId;
		this.benefitId = benefitId;
		this.amountClaimed = amountClaimed;
		this.amountSettled = amountSettled;
		this.claimStatus = claimStatus;
		this.description = description;
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
	public double getAmountClaimed() {
		return amountClaimed;
	}
	public void setAmountClaimed(double amountClaimed) {
		this.amountClaimed = amountClaimed;
	}
	public double getAmountSettled() {
		return amountSettled;
	}
	public void setAmountSettled(double amountSettled) {
		this.amountSettled = amountSettled;
	}
	public String getClaimStatus() {
		return claimStatus;
	}
	public void setClaimStatus(String claimStatus) {
		this.claimStatus = claimStatus;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
	
}
