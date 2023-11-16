package com.fis.banksystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fis.banksystem.exception.UserNotFound;
import com.fis.banksystem.model.BankAccount;
import com.fis.banksystem.model.Trans;
import com.fis.banksystem.service.BankAccountService;

@RestController
@RequestMapping("/account")
public class BankAccountController {
	@Autowired
	private BankAccountService bankAccountService;
	@Autowired
	private TransController transController;
	// createAccount
	public String createAccount(int accountNumber, int balance, String accStatus) {
		BankAccount acct = new BankAccount(accountNumber, balance, accStatus);
		bankAccountService.createAccount(acct);
		return "Account added successfully..!";
	}
	// for checking the Balance
	@GetMapping("/{accountNumber}/balance") // http://localhost:8080/account/1122/balance
	public int getBalance(@PathVariable int accountNumber) {
		return bankAccountService.getBalance(accountNumber);
	}
	// for depositing money
	@PutMapping("/{accountNumber}/deposit/{amount}") // http://localhost:8080/account/1122/deposit/60000
	public String depositAmount(@PathVariable int accountNumber, @PathVariable int amount) {
		int initBal = getBalance(accountNumber);
		bankAccountService.depositAmount(accountNumber, amount);
		Trans trans = new Trans(accountNumber, "Deposited", "Completed", initBal, initBal + amount);
		transController.addLog(trans);
		return "Money Deposited Succesfully !";
	}
	// for withdrawing money
	@PutMapping("/{accountNumber}/withdraw/{amount}") // http://localhost:8080/account/1122/withdraw/5000
	public String withdrawAmount(@PathVariable int accountNumber, @PathVariable int amount) {
		int initBal = getBalance(accountNumber);
		bankAccountService.withdrawAmount(accountNumber, amount);
		Trans trans = new Trans(accountNumber, "Withdrawn", "Completed", initBal, initBal - amount);
		transController.addLog(trans);
		return "Money Withdrwal Succesfully !";
	}
	// for transferring money
	@PutMapping("/{accountNumber}/transfer/{destAccountNumber}/{amount}") // http://localhost:8080/account/1122/transfer/1123/10000
	public String transferAmount(@PathVariable int accountNumber, @PathVariable int destAccountNumber, @PathVariable int amount) {
		int initBalSender = getBalance(accountNumber);
		int initBalReceiver = getBalance(destAccountNumber);
		bankAccountService.transferAmount(accountNumber, destAccountNumber, amount);
		Trans sender = new Trans(accountNumber, "Transferred", "Completed", initBalSender,initBalSender - amount);
		transController.addLog(sender);
		Trans recipient= new Trans(destAccountNumber, "Received", "Completed", initBalReceiver,initBalReceiver + amount);
		transController.addLog(recipient);
		return "Money Transferred Succesfully !";
	}
	// for deleting the Account
	@DeleteMapping("/delete/{accountNumber}") // http://localhost:8080/account/delete/1234567
	public String deleteAccount(@PathVariable int accountNumber) {
		bankAccountService.deleteAccount(accountNumber);
		transController.deleteLog(accountNumber);
		return "Account deleted Successfully..!";
	}
	// AccountInfo
	@GetMapping("/getAccountDetails/{accountNumber}") // http://localhost:8080/account/getAccountDetails/1234567
	public BankAccount getAccountDetails(@PathVariable int accountNumber) throws UserNotFound {
		return bankAccountService.getAccountDetails(accountNumber);
	}
}