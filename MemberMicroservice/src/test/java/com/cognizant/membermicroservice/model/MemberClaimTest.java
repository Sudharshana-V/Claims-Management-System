package com.cognizant.membermicroservice.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;



@SpringBootTest
@RunWith(SpringRunner.class)
public class MemberClaimTest {

	@Mock
	private MemberClaim memberclaim;

	@Test
	@DisplayName("Checking if MemberClaim class is loading or not.")
	void memberClaimIsLoadedOrNot() {
		assertThat(memberclaim).isNotNull();
	}

	

	@DisplayName("Checking if MemberClaim class is responding correctly or not.")
	@Test
	void testingMemberClaim() {
		memberclaim = new MemberClaim(1, 2, 1, 1, 203, 10000.0, 10000.0, "Claimed", "City Hospital Claim");
		memberclaim.setClaimId(3);
		memberclaim.setPolicyId(2);
		memberclaim.setMemberId(4);
		memberclaim.setProviderId(3);
		memberclaim.setBenefitId(202);
		memberclaim.setAmountSettled(50000.0);
		memberclaim.setAmountClaimed(0.0);
		memberclaim.setClaimStatus("Not Claimed");
		memberclaim.setDescription("LIC claim");

		assertEquals(3, memberclaim.getClaimId());
		assertEquals(2, memberclaim.getPolicyId());
		assertEquals(4, memberclaim.getMemberId());
		assertEquals(3, memberclaim.getProviderId());
		assertEquals(202, memberclaim.getBenefitId());
		assertEquals(50000.0, memberclaim.getAmountSettled());
		assertEquals(0.0, memberclaim.getAmountClaimed());
		assertEquals("Not Claimed", memberclaim.getClaimStatus());
		assertEquals("LIC claim", memberclaim.getDescription());

	}
}