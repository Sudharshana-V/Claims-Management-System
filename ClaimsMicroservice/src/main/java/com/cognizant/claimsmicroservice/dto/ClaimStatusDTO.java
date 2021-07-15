package com.cognizant.claimsmicroservice.dto;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@NoArgsConstructor
@Getter
@Setter
@Component
@AllArgsConstructor
public class ClaimStatusDTO {

	@Override
	public String toString() {
		return "ClaimStatusDTO [claimStatus=" + claimStatus + ", description=" + description + "]";
	}
	@JsonProperty
	private String claimStatus;
	@JsonProperty
	private String description;
	public String getClaimStatus() {
		return claimStatus;
	}
	public void setClaimStatus(String claimStatus) {
		this.claimStatus = claimStatus;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
