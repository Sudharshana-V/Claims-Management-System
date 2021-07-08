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
	public void setDescription(Object claimDescription) {
		// TODO Auto-generated method stub
		
	}
	
	public void setClaimStatus(Object claimStatus2) {
		// TODO Auto-generated method stub
		
	}
	
}
