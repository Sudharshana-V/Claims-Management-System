package com.cognizant.membermicroservice.dto;

import java.util.Date;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Component
public class ViewBillsDTO {

	private Date paidDate;
	private double premium;
	private boolean latePayment;
	private double latePaymentCharges;
	private Date dueDate;
	
	
	public ViewBillsDTO(Date paidDate, double premium, boolean latePayment, double latePaymentCharges, Date dueDate) {
		super();
		this.paidDate = paidDate;
		this.premium = premium;
		this.latePayment = latePayment;
		this.latePaymentCharges = latePaymentCharges;
		this.dueDate = dueDate;
	}
	public ViewBillsDTO() {
		
	}
	public Date getPaidDate() {
		return paidDate;
	}
	public void setPaidDate(Date paidDate) {
		this.paidDate = paidDate;
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
	public Date getDueDate() {
		return dueDate;
	}
	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}
	
}
