package com.cognizant.membermicroservice.model;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Component
@Data
public class MemberPolicy {
	
	private int memberId;
	private String memberName;
	private int policyId;
	private String subscriptionDate;
	private int locationId;
	private String locationName;
	private int providerId;
	private String providerName;
	private int topupFrequency;
}
