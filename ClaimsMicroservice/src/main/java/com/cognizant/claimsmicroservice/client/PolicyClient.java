package com.cognizant.claimsmicroservice.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cognizant.claimsmicroservice.model.Benefits;
import com.cognizant.claimsmicroservice.model.ProviderPolicy;


@FeignClient(name = "policy-microservice", url = "http://localhost:8080/policy")
public interface PolicyClient {

	//@PostMapping(value = "/saveProvider")
	//public ProviderPolicy setProviderPolicy(@RequestBody ProviderPolicy provider);

	@GetMapping(value = "/getChainOfProviders/{policyId}")
	public List<ProviderPolicy> getChainOfProviders(@PathVariable("policyId") int policyId);

	@GetMapping(value = "/getEligibleBenefits/{policyId}/{memberId}")
	public List<Benefits> getEligibleBenefits(@PathVariable("policyId") int policyId,
			@PathVariable("memberId") int memberId);

	@GetMapping("/getClaimAmount/{policyId}/{memberId}/{benefitId}")
	public double getClaimAmount(@PathVariable int policyId, @PathVariable int memberId,@PathVariable int benefitId);

}