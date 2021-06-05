package com.erpschool.service.signup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.erpschool.dao.signup.UserSignUpDaoInterface;
import com.erpschool.model.signup.UserSignupDetails;

@Service
@Component
@Transactional	
public class SignupServiceImpl implements SignUpInterface{
	
	
	@Autowired
    private	UserSignUpDaoInterface userSignUpDaoInterface;	
	
	@Override
	public Boolean addNewUser(UserSignupDetails userSignupDetails) {
		
		return userSignUpDaoInterface.addNewUser(userSignupDetails);
	}

}
