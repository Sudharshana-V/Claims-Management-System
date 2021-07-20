package com.cognizant.policy.model;

import javax.persistence.Entity;
import javax.persistence.Id;


import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProviderPolicy 
{	
	@Id
	private int providerId;
	@JsonProperty
	private String providerName;
	@JsonProperty
	private int policyId;
	@JsonProperty
	private String location;
	public ProviderPolicy(int providerId, String providerName, int policyId, String location) {
		this.providerId = providerId;
		this.providerName = providerName;
		this.policyId = policyId;
		this.location = location;
	}
	public ProviderPolicy() {
		
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
	public int getPolicyId() {
		return policyId;
	}
	public void setPolicyId(int policyId) {
		this.policyId = policyId;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
}
