package com.cognizant.policy.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.Data;
@Entity
@Data
public class Policy {		
		@Id
		private int policyId;
		private int policyNumber;
		private int benefitId;
		private double premium;
		private int tenure;
		private double capAmountBenefits;
		public int getPolicyId() {
			return policyId;
		}
		public void setPolicyId(int policyId) {
			this.policyId = policyId;
		}
		public int getPolicyNumber() {
			return policyNumber;
		}
		public void setPolicyNumber(int policyNumber) {
			this.policyNumber = policyNumber;
		}
		public int getBenefitId() {
			return benefitId;
		}
		public void setBenefitId(int benefitId) {
			this.benefitId = benefitId;
		}
		public double getPremium() {
			return premium;
		}
		public void setPremium(double premium) {
			this.premium = premium;
		}
		public int getTenure() {
			return tenure;
		}
		public void setTenure(int tenure) {
			this.tenure = tenure;
		}
		public double getCapAmountBenefits() {
			return capAmountBenefits;
		}
		public void setCapAmountBenefits(double capAmountBenefits) {
			this.capAmountBenefits = capAmountBenefits;
		}
		public Policy(int policyId, int policyNumber, int benefitId, double premium, int tenure,
				double capAmountBenefits) {
			this.policyId = policyId;
			this.policyNumber = policyNumber;
			this.benefitId = benefitId;
			this.premium = premium;
			this.tenure = tenure;
			this.capAmountBenefits = capAmountBenefits;
		}
		public Policy() {
		}	
		
}
