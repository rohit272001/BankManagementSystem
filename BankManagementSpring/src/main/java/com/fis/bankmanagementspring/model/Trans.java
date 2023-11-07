package com.fis.bankmanagementspring.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Trans {
	@Id
	private int accountNumber;
	private String transacType;
	private String transacStatus;
	private int initBal;
	private int finalBal;
	public int getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getTransacType() {
		return transacType;
	}
	public void setTransacType(String transacType) {
		this.transacType = transacType;
	}
	public String getTransacStatus() {
		return transacStatus;
	}
	public void setTransacStatus(String transacStatus) {
		this.transacStatus = transacStatus;
	}
	public int getInitBal() {
		return initBal;
	}
	public void setInitBal(int initBal) {
		this.initBal = initBal;
	}
	public int getFinalBal() {
		return finalBal;
	}
	public void setFinalBal(int finalBal) {
		this.finalBal = finalBal;
	}
	@Override
	public String toString() {
		return "Trans [accountNumber=" + accountNumber + ", transacType=" + transacType + ", transacStatus="
				+ transacStatus + ", initBal=" + initBal + ", finalBal=" + finalBal + "]";
	}
	public Trans(int accountNumber, String transacType, String transacStatus, int initBal, int finalBal) {
		super();
		this.accountNumber = accountNumber;
		this.transacType = transacType;
		this.transacStatus = transacStatus;
		this.initBal = initBal;
		this.finalBal = finalBal;
	}
	public Trans() {
		
	}

	

}
