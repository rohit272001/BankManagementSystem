package com.fis.bankmanagementspring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fis.bankmanagementspring.model.Trans;
import com.fis.bankmanagementspring.service.TransService;

@RestController
@RequestMapping("/account")
public class TransController {
	@Autowired
	private TransService transService;

	// add Log
	public void addLog(Trans trans) {
		transService.addLog(trans);
	}

	// show Log
	@GetMapping("/{accountNumber}/logs") // http://localhost:1111/account/1234567/logs
	public Trans showLog(@PathVariable int accountNumber) {
		return transService.showLog(accountNumber);
	}
	 
	// delete Log
	@DeleteMapping("/deleteLog/{accountNumber}/logs") // http://localhost:1111/account/deleteLog/1234567/logs
	public void deleteLog(int accountNumber) {
		transService.deleteLog(accountNumber);
	}
}
