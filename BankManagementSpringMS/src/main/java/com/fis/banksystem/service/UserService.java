package com.fis.banksystem.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fis.banksystem.exception.UserNotFound;
import com.fis.banksystem.model.BankAccount;
import com.fis.banksystem.model.User;
import com.fis.banksystem.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepo;

	public void createUser(User user) {
		userRepo.save(user);
	}

	public User getUserDetails(int accountNumber) throws UserNotFound {
		Optional<User> optional = userRepo.findById(accountNumber);
		if (optional.isPresent()) {
			return optional.get();
		} else {
			throw new UserNotFound("Account Number is invalid...");
		}

	}

	public void deleteUser(int accountNumber) {
		userRepo.deleteById(accountNumber);
	}


}
