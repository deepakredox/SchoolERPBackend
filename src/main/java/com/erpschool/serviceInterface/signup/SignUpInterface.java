package com.erpschool.serviceInterface.signup;

import com.erpschool.dto.signup.UserSignupDTO;
import com.erpschool.model.signup.UserSignupDetails;

public interface SignUpInterface {

	UserSignupDTO addNewUser(UserSignupDetails userSignupDetails);

}


