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
	public void setPaidDate(Object paidDate2) {
		// TODO Auto-generated method stub
		
	}
	public void setPremium(Object premium2) {
		// TODO Auto-generated method stub
		
	}
	public void setLatePayment(Object latePayment2) {
		// TODO Auto-generated method stub
		
	}
	public void setLatePaymentCharges(Object latePaymentCharges2) {
		// TODO Auto-generated method stub
		
	}
	public void setDueDate(Object dueDate2) {
		// TODO Auto-generated method stub
		
	}
}
