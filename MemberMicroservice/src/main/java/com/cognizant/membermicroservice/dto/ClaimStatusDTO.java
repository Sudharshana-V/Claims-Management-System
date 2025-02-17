package com.cognizant.membermicroservice.dto;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@Component
@ToString
public class ClaimStatusDTO {

	private String claimStatus;
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
	
	public ClaimStatusDTO() {
		
	}
	public ClaimStatusDTO(String claimStatus, String description) {
		super();
		this.claimStatus = claimStatus;
		this.description = description;
	}
	@Override
	public String toString() {
		return "ClaimStatusDTO [claimStatus=" + claimStatus + ", description=" + description + "]";
	}
	
	
}
