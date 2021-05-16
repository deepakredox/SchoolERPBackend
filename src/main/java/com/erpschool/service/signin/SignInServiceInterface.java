package com.erpschool.service.signin;

import org.springframework.security.core.userdetails.UserDetails;

public interface SignInServiceInterface {

	UserDetails getUserAccessInfo(String username,String password);
}


