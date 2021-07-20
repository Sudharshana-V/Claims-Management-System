package com.cognizant.memberportal.DTO;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonProperty;





@Component

public class ClaimStatusDTO {

	@Override
	public String toString() {
		return "ClaimStatusDTO [claimStatus=" + claimStatus + ", description=" + description + "]";
	}
	@JsonProperty
	private String claimStatus;
	@JsonProperty
	private String description;
	
	
	public ClaimStatusDTO() {
	}
	public String getClaimStatus() {
		return claimStatus;
	}
	public void setClaimStatus(String claimStatus) {
		this.claimStatus = claimStatus;
	}
	public String getDescription() {
		return description;
	}
	public ClaimStatusDTO(String claimStatus, String description) {
		this.claimStatus = claimStatus;
		this.description = description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
