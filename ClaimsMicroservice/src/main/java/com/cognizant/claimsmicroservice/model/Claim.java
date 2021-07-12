package com.cognizant.claimsmicroservice.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "claim")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Component
public class Claim {

	@Id
	private int claimId;
	private String claimStatus;
	private String description;
	private int policyId;
	
	public Claim(int claimId, String claimStatus, String description, int policyId, int memberId, int benefitId,
			int providerId, double amountClaimed, double amountSettled) {
		super();
		this.claimId = claimId;
		this.claimStatus = claimStatus;
		this.description = description;
		this.policyId = policyId;
		this.memberId = memberId;
		this.benefitId = benefitId;
		this.providerId = providerId;
		this.amountClaimed = amountClaimed;
		this.amountSettled = amountSettled;
	}
	public int getClaimId() {
		return claimId;
	}
	public void setClaimId(int claimId) {
		this.claimId = claimId;
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
	public int getBenefitId() {
		return benefitId;
	}
	public void setBenefitId(int benefitId) {
		this.benefitId = benefitId;
	}
	public int getProviderId() {
		return providerId;
	}
	public void setProviderId(int providerId) {
		this.providerId = providerId;
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
	private int memberId;
	private int benefitId;
	private int providerId;
	private double amountClaimed;
	private double amountSettled;
	
	
	
	
}
