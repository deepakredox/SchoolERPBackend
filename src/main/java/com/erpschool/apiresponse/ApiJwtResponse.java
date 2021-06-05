package com.erpschool.apiresponse;

import java.time.Instant;

public class ApiJwtResponse {
	
	private  int status;
	private  boolean success;
	private  String message;
	private  String timestamp;
	private  Object result;
	
	
	
	public ApiJwtResponse() {
		
	}

	public ApiJwtResponse(int status, String message, boolean success) {
		this.status = status;
		this.message = message;
		this.success = success;
		this.timestamp = Instant.now().toString();
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public Object getResult() {
		return result;
	}

	public void setResult(Object result) {
		this.result = result;
	}
}
