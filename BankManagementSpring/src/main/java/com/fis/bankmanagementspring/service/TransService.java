package com.fis.bankmanagementspring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fis.bankmanagementspring.model.Trans;
import com.fis.bankmanagementspring.repository.TransRepository;

@Service
public class TransService {
	@Autowired
	TransRepository transRepo;

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
