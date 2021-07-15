package com.cognizant.membermicroservice.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Member {
	@Id
	private int memberId;
	private String memberName;
	public Member() {
	}
	private String phoneNumber;
	private int salary;
	private String gender;
	
	public Member(int memberId, String memberName, String phoneNumber, int salary, String gender) {
		super();
		this.memberId = memberId;
		this.memberName = memberName;
		this.phoneNumber = phoneNumber;
		this.salary = salary;
		this.gender = gender;
	}
	public int getMemberId() {
		return memberId;
	}
	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
}
