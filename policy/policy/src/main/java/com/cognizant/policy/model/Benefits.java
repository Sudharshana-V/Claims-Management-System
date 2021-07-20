package com.cognizant.policy.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Entity
//@Table(name="benefits")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Benefits {

	@Id
	@JsonProperty
	private int benefitId;
	@JsonProperty
	private String benefitName;
	public Benefits() {
	}
	public Benefits(int benefitId, String benefitName) {
		
		this.benefitId = benefitId;
		this.benefitName = benefitName;
	}
	public int getBenefitId() {
		return benefitId;
	}
	public void setBenefitId(int benefitId) {
		this.benefitId = benefitId;
	}
	public String getBenefitName() {
		return benefitName;
	}
	public void setBenefitName(String benefitName) {
		this.benefitName = benefitName;
	}
	
}
