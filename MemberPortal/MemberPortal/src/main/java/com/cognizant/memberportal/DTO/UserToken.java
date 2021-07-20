package com.cognizant.memberportal.DTO;


public class UserToken {


	private String userid;

	private String authToken;

	public UserToken(String userid, String authToken) {
		this.userid = userid;
		this.authToken = authToken;
	}

	public UserToken() {
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getAuthToken() {
		return authToken;
	}

	public void setAuthToken(String authToken) {
		this.authToken = authToken;
	}

	
	
	
}