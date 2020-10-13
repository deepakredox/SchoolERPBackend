package com.erpschool.controller.signup;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.erpschool.apiresponse.ResponseObjectXML;
import com.erpschool.dto.signup.UserSignupDTO;
import com.erpschool.model.signup.UserSignupDetails;
import com.erpschool.serviceInterface.signup.SignUpInterface;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class RegisterController {

	@Autowired
	private SignUpInterface  signUpInterface; 
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public Boolean saveUser(@RequestBody UserSignupDetails userSignupDetails) throws Exception {

		Boolean result = false;
		try 
		{
		  UserSignupDTO userSignupDTO = signUpInterface.addNewUser(userSignupDetails);

		  if (userSignupDTO == null)
		  {
		   result = true;	
		  }
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
