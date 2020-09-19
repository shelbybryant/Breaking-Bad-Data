package com.revature.models;

import org.springframework.stereotype.Component;

@Component
public class LoginDTO {

	public String email;
	public String password;
	
	public LoginDTO() {
		super();
	}

	public LoginDTO(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}
	
}
