package com.fis.banksystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fis.banksystem.model.Trans;
import com.fis.banksystem.service.TransService;

@RestController
@RequestMapping("/account")
public class TransController {
	@Autowired
	private TransService transService;

	// to add Log in the transService
	public void addLog(Trans trans) {
		transService.addLog(trans);
	}

	// to show Log in the transService
	@GetMapping("/{accountNumber}/logs") // http://localhost:1111/account/1234567/logs
	public Trans showLog(@PathVariable int accountNumber) {
		return transService.showLog(accountNumber);
	}
	 
	// to delete Log in the transService
	@DeleteMapping("/deleteLog/{accountNumber}/logs") // http://localhost:1111/account/deleteLog/1234567/logs
	public void deleteLog(int accountNumber) {
		transService.deleteLog(accountNumber);
	}
}
