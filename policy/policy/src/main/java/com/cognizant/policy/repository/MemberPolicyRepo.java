package com.cognizant.policy.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cognizant.policy.model.MemberPolicy;

@Repository
public interface MemberPolicyRepo extends JpaRepository<MemberPolicy , Integer>{

	public List<MemberPolicy> findAllByPolicyIdAndMemberId(int policyId, int memberId);
	
	@Query("from MemberPolicy mp where mp.policyId=?1 and mp.memberId=?2 and mp.benefitId=?3")
	public MemberPolicy findCapAmount(int policyId, int memberId, int benefitId);
	
}