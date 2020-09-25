package com.erpschool.apiresponse;

import java.io.Serializable;

public class AuthenticationJwtResponse implements Serializable {
	
	private static final long serialVersionUID = -8091879091924046844L;
	private final String jwttoken;
	private String tokentype;

	public AuthenticationJwtResponse(String jwttoken, String tokentype) {
		super();
		this.jwttoken = jwttoken;
		this.tokentype = tokentype;
	}

	public String getToken() {
		return this.jwttoken;
	}

	public String getTokentype() {
		return tokentype;
	}
}
