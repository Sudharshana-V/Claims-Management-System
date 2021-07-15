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
	
	private int memberId;
	
	private int policyId;
	
	private Date paidDate;
	
	private Date dueDate;
	
	private double premium;

	private boolean latePayment;
	
	
	private double latePaymentCharges;
	public MemberPremium() {
		
	}
	
	public MemberPremium(int memberId, int policyId, Date paidDate, Date dueDate, double premium, boolean latePayment,
			double latePaymentCharges) {
		super();
		this.memberId = memberId;
		this.policyId = policyId;
		this.paidDate = paidDate;
		this.dueDate = dueDate;
		this.premium = premium;
		this.latePayment = latePayment;
		this.latePaymentCharges = latePaymentCharges;
	}
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
	
	
	

}