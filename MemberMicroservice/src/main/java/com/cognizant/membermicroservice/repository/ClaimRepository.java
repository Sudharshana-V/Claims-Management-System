package com.cognizant.membermicroservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.membermicroservice.model.MemberClaim;

@Repository
public interface ClaimRepository extends JpaRepository<MemberClaim, Integer> {

	public List<MemberClaim> findBymemberId(Integer memberId);

	public List<MemberClaim> findBypolicyId(Integer policyId);

	public List<MemberClaim> findByclaimId(Integer claimId);

	MemberClaim save(MemberClaim claims);

}
