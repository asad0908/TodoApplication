package com.seclore.todoapplication.model.user;

public class SignUpUserDTO {
	private String name, mobile, email, password;
	
	public SignUpUserDTO() {
		// TODO Auto-generated constructor stub
	}

	public SignUpUserDTO(String name, String mobile, String email, String password) {
		super();
		this.name = name;
		this.mobile = mobile;
		this.email = email;
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
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
		return "UserDTO [name=" + name + ", mobile=" + mobile + ", email=" + email + ", password=" + password + "]";
	}
	
	
}
