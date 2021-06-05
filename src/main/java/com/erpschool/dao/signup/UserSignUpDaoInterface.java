package com.erpschool.dao.signup;

import org.springframework.stereotype.Repository;
import com.erpschool.model.signup.UserSignupDetails;

@Repository
public interface UserSignUpDaoInterface {

	Boolean addNewUser(UserSignupDetails userSignupDetails);
}