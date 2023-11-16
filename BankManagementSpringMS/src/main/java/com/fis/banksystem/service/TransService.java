package com.fis.banksystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fis.banksystem.model.Trans;
import com.fis.banksystem.repository.TransRepository;


// in service annotation indicates service layer where are the business logic resides
@Service
public class TransService {
	
	//Autowired annotation is used for dependency injection 
	@Autowired
	TransRepository transRepo; 		//creating object of the TransRepository to work with transRepo class

	
	
	public void addLog(Trans trans) {
		transRepo.save(trans);
	}

	public Trans showLog(int accountNumber) {
		return transRepo.findById(accountNumber).orElse(null);
	}

	public void deleteLog(int accountNumber) {
		transRepo.deleteById(accountNumber);
	}
}
