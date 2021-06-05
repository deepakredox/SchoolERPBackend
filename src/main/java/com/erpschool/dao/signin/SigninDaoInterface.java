package com.erpschool.dao.signin;

import org.springframework.stereotype.Repository;

import com.erpschool.model.signin.UserSignInDtls;

@Repository
public interface SigninDaoInterface {
	
	UserSignInDtls getUserAccessInfo(String uname);

	String getUserEncryptPass(String uname);
}






