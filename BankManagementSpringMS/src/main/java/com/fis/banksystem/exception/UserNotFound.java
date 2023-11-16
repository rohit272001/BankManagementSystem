package com.fis.banksystem.exception;

public class UserNotFound extends Exception {
	/**
	 * User Not found exception to handle the exception when a particular user id or account number is not found 
	 * in the system.
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserNotFound(String message) {
		super(message);
	}
}
