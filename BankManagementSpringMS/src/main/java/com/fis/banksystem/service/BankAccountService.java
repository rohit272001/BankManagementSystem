package com.fis.banksystem.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fis.banksystem.exception.UserNotFound;
import com.fis.banksystem.model.BankAccount;
import com.fis.banksystem.repository.BankAccountRepository;

@Service
public class BankAccountService {
	@Autowired
	private BankAccountRepository repo;

	public void createAccount(BankAccount a) {
		repo.save(a);
	}

	public BankAccount getAccountDetails(int accountNumber) throws UserNotFound{
		Optional<BankAccount> optional = repo.findById(accountNumber);
		if (optional.isPresent()) {
			return optional.get();
		} else {
			throw new UserNotFound("Account Number is invalid...");
		}
		//return repo.findById(accountNumber).orElse(null);
	}

	public void deleteAccount(int accountNumber) {
		repo.deleteById(accountNumber);
	}

	public int getBalance(int accountNumber) {
		return repo.findBalance(accountNumber);
	}

	public void depositAmount(int accountNumber, int amount) {
		repo.saveBalance(accountNumber, amount);
	}

	public void withdrawAmount(int accountNumber, int amount) {
		repo.withdrawAmount(accountNumber, amount);
	}

	public void transferAmount(int accountNumber, int destAccountNumber, int amount) {
		repo.withdrawAmount(accountNumber, amount);
		repo.saveBalance(destAccountNumber, amount);
	}

}
