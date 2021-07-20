package com.cognizant.policy.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;


import lombok.AllArgsConstructor;
import lombok.Data;
//import lombok.Getter;
import lombok.NoArgsConstructor;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MemberPolicy {

	@Id
	private int memberId;
	private int policyId;
	private int policyNumber;
	private int benefitId;
	private Date subscriptionDate;
	private int tenure;
	private double capAmountBenefits;
	public int getMemberId() {
		return memberId;
	}
	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}
	public int getPolicyId() {
		return policyId;
	}
	public void setPolicyId(int policyId) {
		this.policyId = policyId;
	}
	public int getPolicyNumber() {
		return policyNumber;
	}
	public void setPolicyNumber(int policyNumber) {
		this.policyNumber = policyNumber;
	}
	public int getBenefitId() {
		return benefitId;
	}
	public void setBenefitId(int benefitId) {
		this.benefitId = benefitId;
	}
	public Date getSubscriptionDate() {
		return subscriptionDate;
	}
	public void setSubscriptionDate(Date subscriptionDate) {
		this.subscriptionDate = subscriptionDate;
	}
	public int getTenure() {
		return tenure;
	}
	public void setTenure(int tenure) {
		this.tenure = tenure;
	}
	public double getCapAmountBenefits() {
		return capAmountBenefits;
	}
	public void setCapAmountBenefits(double capAmountBenefits) {
		this.capAmountBenefits = capAmountBenefits;
	}
	public MemberPolicy() {
	}
	public MemberPolicy(int memberId, int policyId, int policyNumber, int benefitId, Date subscriptionDate, int tenure,
			double capAmountBenefits) {
		super();
		this.memberId = memberId;
		this.policyId = policyId;
		this.policyNumber = policyNumber;
		this.benefitId = benefitId;
		this.subscriptionDate = subscriptionDate;
		this.tenure = tenure;
		this.capAmountBenefits = capAmountBenefits;
	}
	

}
