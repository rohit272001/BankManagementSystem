package com.fis.banksystem.model;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
 
// Testing module for User of the Bank to check for the 
//	AccountId
//	CustomerId
//	AccountType
 
public class UserTest {
 
	User u = new User();
	
	// Testing to check whether the expected account number matches or not 
	// if it matches all the test will pass otherwise it fails 
	@Test
	void setAccountIdTest() {
		u.setAccountNumber(2023);
		assertEquals(2023, u.getAccountNumber());
	}
	
	

	// Testing to check whether the expected customer id matches or not 
	// if it matches all the test will pass otherwise it fails 
	@Test
	void setCustomerIdTest() {
		u.setUserName("Rohit");
		assertEquals("Rohit", u.getUserName());
	}
 
	

	// Testing to check whether the expected account Type matches or not 
	// if it matches all the test will pass otherwise it fails 
	
	@Test
	void setAccountTypeTest() {
		u.setAccType("savings");
		assertEquals("savings", u.getAccType());
	}
 
//	@Test
//	void getAccTest() {
//		u.setAccNo(1);
//		assertEquals(1, u.getAccNo());
//	}
}
