package com.cognizant.membermicroservice.model;

import javax.persistence.Entity;


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
	public MemberPolicy() {
		
	}
	public MemberPolicy(int memberId, String memberName, int policyId, String subscriptionDate, int locationId,
			String locationName, int providerId, String providerName) {
		super();
		this.memberId = memberId;
		this.memberName = memberName;
		this.policyId = policyId;
		this.subscriptionDate = subscriptionDate;
		this.locationId = locationId;
		this.locationName = locationName;
		this.providerId = providerId;
		this.providerName = providerName;
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
	public int getPolicyId() {
		return policyId;
	}
	public void setPolicyId(int policyId) {
		this.policyId = policyId;
	}
	public String getSubscriptionDate() {
		return subscriptionDate;
	}
	public void setSubscriptionDate(String subscriptionDate) {
		this.subscriptionDate = subscriptionDate;
	}
	public int getLocationId() {
		return locationId;
	}
	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}
	public String getLocationName() {
		return locationName;
	}
	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}
	public int getProviderId() {
		return providerId;
	}
	public void setProviderId(int providerId) {
		this.providerId = providerId;
	}
	public String getProviderName() {
		return providerName;
	}
	public void setProviderName(String providerName) {
		this.providerName = providerName;
	}
	
}
