package com.cognizant.membermicroservice.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MemberPolicy {
	
	private int memberId;
	private String memberName;
	private int policyId;
	private String subscriptionDate;
	private int locationId;
	private String locationName;
	private int providerId;
	private String providerName;
	
	//private int topupFrequency;
	
	

}
