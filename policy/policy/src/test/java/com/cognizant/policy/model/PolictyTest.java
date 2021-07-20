package com.cognizant.policy.model;



import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/*
 * Test Cases for Policy class
 */
@SpringBootTest
@RunWith(SpringRunner.class)
class PolictyTest {

	@Mock
	public Policy policy;

	/*
	 * test the Policy class is loading or not
	 */
	@Test
	@DisplayName("Checking if policy is loading or not.")
	 void policyIsLoaded() {
		assertThat(policy).isNotNull();
	}
	
	/*
	 * test the Policy class is working properly or not
	 */
	@Test
	@DisplayName("Checking if policy class is working properly")
	 void policyTest() {
		
		policy = new Policy(1,101,201,5000.0,25,150000.00);
		assertEquals(1,policy.getPolicyId());
		assertEquals(101,policy.getPolicyNumber());
		assertEquals(201,policy.getBenefitId());
		assertEquals(5000.0,policy.getPremium());
		assertEquals(25,policy.getTenure());
		assertEquals(150000.00,policy.getCapAmountBenefits());
		
		
	}
	
	
	
	
	@BeforeEach
	void setUp() {
		policy=new Policy();
		policy.setBenefitId(1);
		policy.setCapAmountBenefits(10000.0);
		policy.setPolicyId(1);
		policy.setPolicyNumber(2);
		policy.setPremium(5000.0);
		policy.setTenure(10);
	}
	
	@Test
	 void testsetpolicyId() {
		policy = new Policy();
		policy.setPolicyId(1);
		assertEquals(1,policy.getPolicyId());	
				
	}
	@Test
	 void testsetBenefitId() {
		policy = new Policy();
		policy.setBenefitId(1);
		assertEquals(1,policy.getBenefitId());	
				
	}
	@Test
	 void testsetPolicyNumber() {
		policy = new Policy();
		policy.setPolicyNumber(1);
		assertEquals(1,policy.getPolicyNumber());	
				
	}
	@Test
	 void testsetTenure() {
		policy = new Policy();
		policy.setTenure(1);
		assertEquals(1,policy.getTenure());	
				
	}
	@Test
	 void testsetPremium() {
		policy = new Policy();
		policy.setPremium(100.0);
		assertEquals(100.0,policy.getPremium());	
				
	}
	
	
}
