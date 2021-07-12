package com.cognizant.claimsmicroservice.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="benefits")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Benefits {
	
	@Id
	@JsonProperty
	private int benefitId;
	@JsonProperty
	private String benefitName;
	public Benefits(int benefitId, String benefitName) {
		super();
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
