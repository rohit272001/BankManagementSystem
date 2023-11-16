package com.fis.banksystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.fis.banksystem.model.BankAccount;

public interface BankAccountRepository extends CrudRepository<BankAccount, Integer>, JpaRepository<BankAccount, Integer> {
	@Query("select balance from BankAccount where accountNumber = ?1") // display the balance
	public int findBalance(int accountNumber);

	@Transactional
	@Modifying(clearAutomatically = true)
	@Query("update BankAccount set balance = balance+?2 where accountNumber=?1") // deposit
																		
	public void saveBalance(int accountNumber, int balance);

	@Transactional
	@Modifying(clearAutomatically = true)
	@Query("update BankAccount set balance = balance-?2 where accountNumber=?1") // withdraw
	public void withdrawAmount(int accountNumber, int balance);

	

}
