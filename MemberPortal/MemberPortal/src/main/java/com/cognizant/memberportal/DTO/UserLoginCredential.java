package com.cognizant.memberportal.DTO;







public class UserLoginCredential {

	private String userid;

	private String password;

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserLoginCredential() {
	}

	public UserLoginCredential(String userid, String password) {
		this.userid = userid;
		this.password = password;
	}
	
	
	
}