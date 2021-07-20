package com.cognizant.policy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cognizant.policy.model.Benefits;

@Repository
public interface BenefitRepo extends JpaRepository<Benefits, Integer> {

	public Benefits findByBenefitId(int benefitId);

}