package com.erpschool.apiresponse;

import java.util.ArrayList;
import java.util.List;

public class ResponseObjectXML<T> {
	
	private int statusCode;
	private String message;
	private List<T> data = new ArrayList<T>() ;
	
	
	public List<T> getData() {
		return data;
	}
	public void setData(List<T> data) {
		this.data = data;
	}
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
