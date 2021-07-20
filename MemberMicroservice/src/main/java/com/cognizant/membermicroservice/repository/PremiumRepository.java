package com.cognizant.membermicroservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.cognizant.membermicroservice.model.MemberPremium;

@Repository
public interface PremiumRepository extends JpaRepository<MemberPremium, Integer>{

public List<MemberPremium> findBypolicyId(Integer policyId);

public List<MemberPremium> findBymemberId(Integer memberId);



}