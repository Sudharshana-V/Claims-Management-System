package com.cognizant.claimsmicroservice.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="provider_policy")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProviderPolicy {
	
	@Id
	@JsonProperty
	public int providerId;
	@JsonProperty
	public String providerName;
	@JsonProperty
	public String providerAddress;
	@JsonProperty
	public int policyId;
	@JsonProperty
	public String location;
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
	public String getProviderAddress() {
		return providerAddress;
	}
	public void setProviderAddress(String providerAddress) {
		this.providerAddress = providerAddress;
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
	public ProviderPolicy(int providerId, String providerName, String providerAddress, int policyId, String location) {
		super();
		this.providerId = providerId;
		this.providerName = providerName;
		this.providerAddress = providerAddress;
		this.policyId = policyId;
		this.location = location;
	}
	public ProviderPolicy() {
	}
	
	
	
	
}
