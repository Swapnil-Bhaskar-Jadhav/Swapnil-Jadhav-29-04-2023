package com.avisys.cim.dto;

import java.time.LocalDateTime;

public class ErrorResponse {
	private String message;
	private String errorDetails;
	private LocalDateTime timeStamp;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getErrorDetails() {
		return errorDetails;
	}
	public void setErrorDetails(String errorDetails) {
		this.errorDetails = errorDetails;
	}
	public LocalDateTime getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(LocalDateTime timeStamp) {
		this.timeStamp = timeStamp;
	}
	public ErrorResponse(String message, String errorDetails) {
		super();
		this.message = message;
		this.errorDetails = errorDetails;
		timeStamp=LocalDateTime.now();
	
	}
	public ErrorResponse() {
		super();
	}
	
	
	

}
