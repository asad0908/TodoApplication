package com.seclore.todoapplication.model.user;

public class LoginUserDTO {
	private String email, password;

	public LoginUserDTO() {
	}

	public LoginUserDTO(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "LoginUserDTO [email=" + email + ", password=" + password + "]";
	}
	
	
}
