package com.fis.banksystem.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/*
{
	  "password": "Rohit@123",
	  "role": "admin",
	  "username": "Rohit"
	}
*/

public class UserDTO {
	@Size(min = 3, max = 15, message = "Name length must be between 3-15")
	@NotBlank(message = "Name cannot be null or whitespace")
	private String username;
	@Size(min = 3, max = 15, message = "password length must be between 3-15")
	private String password;
	private String role;

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "UserDTO [username=" + username + ", password=" + password + ", role=" + role + "]";
	}
}