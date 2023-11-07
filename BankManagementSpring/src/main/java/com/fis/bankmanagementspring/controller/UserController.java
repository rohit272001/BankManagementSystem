package com.fis.bankmanagementspring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fis.bankmanagementspring.exception.ExceptionHandler;
import com.fis.bankmanagementspring.exception.UserNotFound;
import com.fis.bankmanagementspring.model.User;
import com.fis.bankmanagementspring.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;
	@Autowired
	private BankAccountController accountController;
	
    // creating customer
	@PostMapping("/createUser") // http://localhost:1111/user/createUser
	public String createUser(@RequestBody @Validated User user) {
		userService.createUser(user);
		accountController.createAccount(user.getAccountNumber(), 0, "Active");
		return "Account Created Succesfully!";
	}

	// get the user info
	@GetMapping("/getUserDetails/{accountNumber}") // http://localhost:1111/user/getUserDetails/1234567
	
	public void getUserDetails(@PathVariable int accountNumber) throws UserNotFound {
		userService.getUserDetails(accountNumber);
	}
//	public ResponseEntity<?> getUserDetails(@PathVariable int accountNumber) {
//        User u = userService.getUserDetails(accountNumber);
//        if (u == null) {
//          ExceptionHandler e = new ExceptionHandler(); 
//          e.setInfo("Wrong Account Number!");
//          return new ResponseEntity<>(e, HttpStatus.NOT_FOUND);
//         }
//       return new ResponseEntity<>(u, HttpStatus.OK);
//    }    
	

	// delete the user
	@DeleteMapping("/deleteUser/{accountNumber}") // http://localhost:1111/user/deleteUser/1234567
	public String deleteUser(@PathVariable int accountNumber) throws UserNotFound {
		userService.deleteUser(accountNumber);
		return "Account Deleted Succesfully!";
	}

}
