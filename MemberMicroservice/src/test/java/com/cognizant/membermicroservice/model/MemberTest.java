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
public class MemberTest {

	@Mock
	private Member mem;

	@Test
	@DisplayName("Checking if Member class is loading or not.")
	void memberIsLoadedOrNot() {
		assertThat(mem).isNotNull();
	}

	

	@DisplayName("Checking if Member class is responding correctly or not.")
	@Test
	void testingMember() {

		mem = new Member(1, "Abhi", "9898767876", 15000, "Male");
		mem.setMemberId(3);
		mem.setMemberName("Bruce");
		mem.setPhoneNumber("8998765434");
		mem.setSalary(20000);
		mem.setGender("Male");

		assertEquals(3, mem.getMemberId());
		assertEquals("Bruce", mem.getMemberName());
		assertEquals("8998765434", mem.getPhoneNumber());
		assertEquals(20000, mem.getSalary());
		assertEquals("Male", mem.getGender());

	}
}