package com.erpschool.dao.signin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.erpschool.model.signin.UserSignInDtls;
import com.erpschool.repository.signin.UserSignInCustomQueryInterface;

@Component
@Transactional
public class SigninDaoImpl implements SigninDaoInterface {
	
	@Autowired
	UserSignInCustomQueryInterface userSignInCustomQueryInterface;

	@Override
	public UserSignInDtls getUserAccessInfo(String uname) {
		
		return userSignInCustomQueryInterface.getUserAccessInfo(uname);
		
	}

	@Override
	public String getUserEncryptPass(String uname) {
		
		return userSignInCustomQueryInterface.getUserEncryptPass(uname);
	}
}
