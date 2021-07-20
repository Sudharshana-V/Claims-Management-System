package com.cognizant.policy.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cognizant.policy.model.ProviderPolicy;

@Repository
public interface ProviderPolicyRepo extends JpaRepository<ProviderPolicy, Integer> 
{
	public List<ProviderPolicy> findAllByPolicyIdOrderByLocation(int policyId);
}