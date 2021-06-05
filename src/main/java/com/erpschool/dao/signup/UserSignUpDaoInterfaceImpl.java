package com.erpschool.dao.signup;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.erpschool.model.signup.UserSignupDetails;
import com.erpschool.repository.signup.UserSignUpCustomQueryInterface;

@Component
@Transactional
public class UserSignUpDaoInterfaceImpl implements UserSignUpDaoInterface {

	@Autowired
	private UserSignUpCustomQueryInterface userSignUpCustomQueryInterface;

	@Override
	public Boolean addNewUser(UserSignupDetails userSignupDetails) {

		return userSignUpCustomQueryInterface.addNewSignUpUser(userSignupDetails);

	}
}
