package com.erpschool.model.signin;

import java.io.Serializable;

public class UserSignInDtls implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id;  
	private String username;
	private String password;
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "UserSignInDtls [id=" + id + ", username=" + username + ", password=" + password + "]";
	}

	public UserSignInDtls() {
		super();
	}
}
