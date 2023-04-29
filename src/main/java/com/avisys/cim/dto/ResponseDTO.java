package com.avisys.cim.dto;

public class ResponseDTO {

	private String Message;
	
	
	public ResponseDTO() {
		
	}

	public ResponseDTO(String message) {
		
		Message = message;
	}

	public String getMessage() {
		return Message;
	}

	public void setMessage(String message) {
		Message = message;
	}
	
	
}
