package com.cognizant.policy.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.cognizant.policy.model.Benefits;
import com.cognizant.policy.model.MemberPolicy;
import com.cognizant.policy.model.ProviderPolicy;
import com.cognizant.policy.repository.BenefitRepo;
import com.cognizant.policy.repository.MemberPolicyRepo;
import com.cognizant.policy.repository.ProviderPolicyRepo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j2;


@RestController
@Log4j2
//@RequestMapping(value="/policy")
@Api(value = "policy Microservice Controller")
public class PolicymicroserviceController {
	
	@Autowired
	public ProviderPolicyRepo providerPolicyRepo;

	@Autowired
	public MemberPolicyRepo memberPolicyRepo;

	@Autowired
	public BenefitRepo benefitRepo;

	public static final Logger logger = LoggerFactory.getLogger(PolicymicroserviceController.class);
	
	@ApiOperation(value = "List of providers which provides the particular policy")
	@ApiModelProperty(value="example of provider list format",example="{location:guntur,provider:apollo}")
	@GetMapping(path = "/getChainOfProviders/{policyId}")
	public ResponseEntity<?> getChainOfProviders(@PathVariable("policyId") Integer policyId) 
	{
		logger.info("at providersPolicy page");
	
		List<ProviderPolicy> providers = providerPolicyRepo.findAllByPolicyIdOrderByLocation(policyId);
		
		return new ResponseEntity<>(providers, HttpStatus.OK);
	}

	@ApiOperation(value = "Retrieves a list of benefits provided policyId and memberId")
	@GetMapping(path = "getEligibleBenefits/{policyId}/{memberId}")
	public ResponseEntity<?> getEligibleBenefits(@PathVariable("policyId") Integer policyId,
			@PathVariable("memberId") Integer memberId) 
	{

		List<MemberPolicy> providers = memberPolicyRepo.findAllByPolicyIdAndMemberId(policyId, memberId);
		logger.info("At retrieve benefits page");
		List<Benefits> benefitDetails = new ArrayList<Benefits>();
		for (MemberPolicy memberPolicy : providers) {
			int benefitId = memberPolicy.getBenefitId();
			benefitDetails.add(benefitRepo.findByBenefitId(benefitId));

		}
		return new ResponseEntity<>(benefitDetails, HttpStatus.OK);

	}

	@ApiOperation(value = "List of benefits which can be aviled under a particular policy")
	@GetMapping(value = "/getClaimAmount/{policyId}/{memberId}/{benefitId}")
	public ResponseEntity<?> getEligibleClaimAmount(@PathVariable Integer policyId, @PathVariable Integer memberId,
			@PathVariable Integer benefitId) 
	{
		logger.trace("At getClaimAmount Page");
		MemberPolicy mempolicy = memberPolicyRepo.findCapAmount(policyId, memberId, benefitId);
		System.out.println(mempolicy.getCapAmountBenefits());
		
		return new ResponseEntity<Double>(mempolicy.getCapAmountBenefits(), HttpStatus.OK);
	}
	
	
}
