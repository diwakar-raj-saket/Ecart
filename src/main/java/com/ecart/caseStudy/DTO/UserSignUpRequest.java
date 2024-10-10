package com.ecart.caseStudy.DTO;

public class UserSignUpRequest {
    private String name;
    private String email;
    private String pasword;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPasword() {
		return pasword;
	}
	public void setPasword(String pasword) {
		this.pasword = pasword;
	}
	public UserSignUpRequest(String name, String email, String pasword) {
		super();
		this.name = name;
		this.email = email;
		this.pasword = pasword;
	}
	public UserSignUpRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
}
