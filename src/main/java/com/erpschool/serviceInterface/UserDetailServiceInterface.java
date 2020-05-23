package com.erpschool.serviceInterface;

import org.springframework.security.core.userdetails.UserDetails;

import com.erpschool.model.UserDTO;
import com.erpschool.model.UserDtls;

public interface UserDetailServiceInterface {

	UserDetails loadUserByUsername(String username);

	UserDTO save(UserDtls user);
}


