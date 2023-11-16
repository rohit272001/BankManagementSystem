package com.fis.banksystem.exception;

import java.time.LocalDateTime;


/*Exception Response class to handle the exception in the form of status 
	and a string message with a time stamp
	*/
public class ExceptionResponse {

	private int status;
	private String message;
	private LocalDateTime time;

	public ExceptionResponse() {
		super();
	}

	// All Args Constructor 
	public ExceptionResponse(int status, String message, LocalDateTime time) {
		super();
		this.status = status;
		this.message = message;
		this.time = time;
	}

	//setter and getter method for the particular attributes
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public LocalDateTime getTime() {
		return time;
	}

	public void setTime(LocalDateTime time) {
		this.time = time;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
}
