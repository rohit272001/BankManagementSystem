package com.fis.bankmanagementspring.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

@Entity
public class BankAccount {
	@Id
	private int accountNumber;
	private int balance;
	private String acctStatus;
	public int getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public String getAcctStatus() {
		return acctStatus;
	}
	public void setAcctStatus(String acctStatus) {
		this.acctStatus = acctStatus;
	}
	@Override
	public String toString() {
		return "BankAccount [accountNumber=" + accountNumber + ", balance=" + balance + ", acctStatus=" + acctStatus
				+ "]";
	}
	public BankAccount(int accountNumber, int balance, String acctStatus) {
		super();
		this.accountNumber = accountNumber;
		this.balance = balance;
		this.acctStatus = acctStatus;
	}
	public BankAccount() {
	}
	


}
