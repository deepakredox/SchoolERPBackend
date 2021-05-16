package com.erpschool.repository.signin;

import com.erpschool.model.signin.UserSignInDtls;

public interface UserSignInCustomQueryInterface {

	UserSignInDtls getUserAccessInfo(String uname);

	String getUserEncryptPass(String uname);

}






