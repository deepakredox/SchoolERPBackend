package com.erpschool.apiresponse;

import org.springframework.http.HttpStatus;

public class ResponseWrapper {
	
	private String timestamp;
	private int statusCode;
	private HttpStatus statusMessage;
	private String desc;
	private AuthenticationJwtResponse authenticationJwtResponse;
	
	public ResponseWrapper(int code, String message) {
		this.statusCode = code;
		this.desc = message;
	}
	
   // default contructore
	public ResponseWrapper() {
	}


	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statuscodee) {
		this.statusCode = statuscodee;
	}
	public HttpStatus getStatusMessage() {
		return statusMessage;
	}
	public void setStatusMessage(HttpStatus statusMessage) {
		this.statusMessage = statusMessage;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public AuthenticationJwtResponse getAuthenticationJwtResponse() {
		return authenticationJwtResponse;
	}
	public void setAuthenticationJwtResponse(AuthenticationJwtResponse authenticationJwtResponse) {
		this.authenticationJwtResponse = authenticationJwtResponse;
	}
}
