package com.erpschool.apiresponse;

import java.util.ArrayList;
import java.util.List;

public class ResponseObjectXML {
	
	private String status;
	private String message;
	private List<String> data = new ArrayList<String>() ;
	
	public List<String> getData() {
		return data;
	}
	public void setData(List<String> data) {
		this.data = data;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
