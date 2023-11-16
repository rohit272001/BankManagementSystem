package com.fis.banksystem.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/*
{
	  "accType": "saving",
	  "accountNumber": 101,
	  "email": "gaurav@123",
	  "mobile": 9685065503,
	  "userName": "Gaurav"
	}
*/

@Entity
public class User {

	@Id
	private int accountNumber;
	@NotBlank(message = "User name cannot be blank or whitespace")
	private String userName;
	@NotNull
	@Min(10)
	private long mobile;
	@NotNull(message = "Email Id cannot be null or whitespace")
	private String email;
	private String accType;

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public long getMobile() {
		return mobile;
	}

	public void setMobile(long mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAccType() {
		return accType;
	}

	public void setAccType(String accType) {
		this.accType = accType;
	}

	@Override
	public String toString() {
		return "User [accountNumber=" + accountNumber + ", userName=" + userName + ", mobile=" + mobile + ", email="
				+ email + ", accType=" + accType + "]";
	}

	public User(int accountNumber, String userName, long mobile, String email, String accType) {
		super();
		this.accountNumber = accountNumber;
		this.userName = userName;
		this.mobile = mobile;
		this.email = email;
		this.accType = accType;
	}

	public User() {
	}

}
