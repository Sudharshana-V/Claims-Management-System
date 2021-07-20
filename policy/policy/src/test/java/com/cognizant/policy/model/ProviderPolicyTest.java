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
 * Test Cases for ProviderPolicy class 
 */
@SpringBootTest
@RunWith(SpringRunner.class)
class ProviderPolicyTest {

	@Mock
	public ProviderPolicy providerPolicy;

	/*
	 * test the ProviderPolicy class is loading or not
	 */
	@Test
	@DisplayName("Checking if ProviderPolicy is loading or not.")
	void providerPolicyIsLoaded() {
		assertThat(providerPolicy).isNotNull();
	}

	/*
	 * test the ProviderPolicy class allArgsConstructor
	 */
	@Test
	 void allArgsConstructorTest() {

		ProviderPolicy newPolicy = new ProviderPolicy(1,"LIC",1,"Kolkata");
		assertEquals(providerPolicy.getProviderId(), newPolicy.getProviderId());
		assertEquals(providerPolicy.getProviderName(), newPolicy.getProviderName());
		assertEquals(providerPolicy.getPolicyId(), newPolicy.getPolicyId());
		assertEquals(providerPolicy.getLocation(), newPolicy.getLocation());
	}

	

	@BeforeEach
	void setUp() {
		providerPolicy = new ProviderPolicy();
		providerPolicy.setProviderId(1);
		providerPolicy.setProviderName("LIC");
		providerPolicy.setPolicyId(1);
		providerPolicy.setLocation("Kolkata");	
	}
	
	@Test
	 void testsetProviderId() {
		providerPolicy = new ProviderPolicy();
		providerPolicy.setProviderId(1);
		assertEquals(1,providerPolicy.getProviderId());	
				
	}
	
	@Test
	 void testsetProviderName() {
		providerPolicy = new ProviderPolicy();
		providerPolicy.setProviderName("ABC");
		assertEquals("ABC",providerPolicy.getProviderName());	
				
	}
	
	
	@Test
	 void testsetPolicyId() {
		providerPolicy = new ProviderPolicy();
		providerPolicy.setPolicyId(1);
		assertEquals(1,providerPolicy.getPolicyId());	
				
	}
	
	@Test
	 void testsetLocation() {
		providerPolicy = new ProviderPolicy();
		providerPolicy.setLocation("ABC");
		assertEquals("ABC",providerPolicy.getLocation());	
				
	}
}
