package com.fis.banksystem.model;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
 
import org.junit.jupiter.api.Test;

//Testing module for the Bank to check for the
//AccountNumber
//Balance 

public class BankAccountTest {
	BankAccount account = new BankAccount();
	
 
	// Testing to check whether the expected account number matches or not from the bank end
	@Test
	void setAccountNumber() {
		account.setAccountNumber(98);
		assertEquals(98, account.getAccountNumber());
		
	}
	
	//	Testing to check whether the expected Balance in the account matches or not 
 
	@Test
	void setBalanceTest() {
		account.setBalance(90000);
		assertEquals(90000, account.getBalance());
	}
 
	
 
}
