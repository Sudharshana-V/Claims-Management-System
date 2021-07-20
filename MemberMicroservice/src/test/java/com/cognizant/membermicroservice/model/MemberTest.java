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
	
	@Test
	void setMemberIdTest() {
		mem = new Member();
		mem.setMemberId(1);
		assertEquals(1,mem.getMemberId());
	}
	
	@Test
	void setMemberNameTest() {
		mem = new Member();
		mem.setMemberName("anu");
		assertEquals("anu",mem.getMemberName());
	}
	
	@Test
	void setPhoneNumberTest() {
		mem = new Member();
		mem.setPhoneNumber("9876543211");
		assertEquals("9876543211",mem.getPhoneNumber());
	}
	
	@Test
	 void setSalaryTest() {
		mem = new Member();
		mem.setSalary(2000);
		assertEquals(2000,mem.getSalary());
	}
	@Test
	public void setGenderTest() {
		mem = new Member();
		mem.setGender("Male");
		assertEquals("Male",mem.getGender());
	}
	
}