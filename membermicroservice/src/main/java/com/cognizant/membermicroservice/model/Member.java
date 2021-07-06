package com.cognizant.membermicroservice.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString

public class Member {
	
	@Id
	private int memberId;
	private String memberName;
	private String phoneNumber;
	private int salary;
	private String gender;
}