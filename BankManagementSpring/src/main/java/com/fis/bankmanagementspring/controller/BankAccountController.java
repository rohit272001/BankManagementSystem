package com.fis.bankmanagementspring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fis.bankmanagementspring.exception.UserNotFound;
import com.fis.bankmanagementspring.model.BankAccount;
import com.fis.bankmanagementspring.model.Trans;
import com.fis.bankmanagementspring.service.BankAccountService;

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
	@GetMapping("/{accountNumber}/balance") // http://localhost:1111/account/1234567/balance
	public int getBalance(@PathVariable int accountNumber) {
		return bankAccountService.getBalance(accountNumber);
	}
	// for depositing money
	@PutMapping("/{accountNumber}/deposit/{amount}") // http://localhost:1111/account/1234567/deposit/90000
	public void depositAmount(@PathVariable int accountNumber, @PathVariable int amount) {
		int initBal = getBalance(accountNumber);
		bankAccountService.depositAmount(accountNumber, amount);
		Trans trans = new Trans(accountNumber, "Deposited", "Completed", initBal, initBal + amount);
		transController.addLog(trans);
	}
	// for withdrawing money
	@PutMapping("/{accountNumber}/withdraw/{amount}") // http://localhost:1111/account/1234567/withdraw/90000
	public void withdrawAmount(@PathVariable int accountNumber, @PathVariable int amount) {
		int initBal = getBalance(accountNumber);
		bankAccountService.withdrawAmount(accountNumber, amount);
		Trans trans = new Trans(accountNumber, "Withdrawn", "Completed", initBal, initBal - amount);
		transController.addLog(trans);
	}
	// for transferring money
	@PutMapping("/{accountNumber}/transfer/{destAccNo}/{amount}") // http://localhost:1111/account/123456/transfer/1234567/10000
	public void transferAmount(@PathVariable int accountNumber, @PathVariable int destAccountNumber, @PathVariable int amount) {
		int initBalSender = getBalance(accountNumber);
		int initBalReceiver = getBalance(destAccountNumber);
		bankAccountService.transferAmount(accountNumber, destAccountNumber, amount);
		Trans sender = new Trans(accountNumber, "Transferred", "Completed", initBalSender,initBalSender - amount);
		transController.addLog(sender);
		Trans recipient= new Trans(destAccountNumber, "Received", "Completed", initBalReceiver,initBalReceiver + amount);
		transController.addLog(recipient);
	}
	// for deleting the Account
	@DeleteMapping("/delete/{accountNumber}") // http://localhost:1111/account/delete/1234567
	public String deleteAccount(@PathVariable int accountNumber) {
		bankAccountService.deleteAccount(accountNumber);
		transController.deleteLog(accountNumber);
		return "Account deleted Successfully..!";
	}
	// AccountInfo
	@GetMapping("/getAccountDetails/{accountNumber}") // http://localhost:1111/account/getAccountDetails/1234567
	public BankAccount getAccountDetails(@PathVariable int accountNumber) throws UserNotFound {
		return bankAccountService.getAccountDetails(accountNumber);
	}
}