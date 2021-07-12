package com.cognizant.membermicroservice.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * This is a model class which we will be storing details of premium of the
 * member in the database..
 * 
 */

@Entity
@Table(name = "member_premium")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Component
@Data
public class MemberPremium {

	@Id
	/**
	 * This will be id of the member.
	 * 
	 */
	private int memberId;
	/**
	 * This will be id of the policy.
	 * 
	 */
	private int policyId;
	/**
	 * This will be the date on which premium of the policy has been paid.
	 * 
	 */
	private Date paidDate;
	/**
	 * This will be the due date of premium of the policy.
	 * 
	 */
	private Date dueDate;
	/**
	 * This will be the amount of premium the member has to pay.
	 * 
	 */
	private double premium;
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
	public Date getPaidDate() {
		return paidDate;
	}
	public void setPaidDate(Date paidDate) {
		this.paidDate = paidDate;
	}
	public Date getDueDate() {
		return dueDate;
	}
	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}
	public double getPremium() {
		return premium;
	}
	public void setPremium(double premium) {
		this.premium = premium;
	}
	public boolean isLatePayment() {
		return latePayment;
	}
	public void setLatePayment(boolean latePayment) {
		this.latePayment = latePayment;
	}
	public double getLatePaymentCharges() {
		return latePaymentCharges;
	}
	public void setLatePaymentCharges(double latePaymentCharges) {
		this.latePaymentCharges = latePaymentCharges;
	}
	/**
	 * This will be the boolean value for the late payment (true or false).
	 * 
	 */
	private boolean latePayment;
	/**
	 * This will be the late payment charges if the member pays the premium after
	 * the due date.
	 * 
	 */
	private double latePaymentCharges;
	

}