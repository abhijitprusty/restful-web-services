package com.learn.cloud.restfulwebservices.exception;

import java.util.Date;

public class ExceptionResponse {

	
	private Date timestamp;
	private String message;
	private String details;
	
	protected ExceptionResponse() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param timestamp
	 * @param message
	 * @param details
	 */
	public ExceptionResponse(Date timestamp, String message, String details) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.details = details;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public String getMessage() {
		return message;
	}

	public String getDetails() {
		return details;
	}
	
	
	
	
	
	

}
