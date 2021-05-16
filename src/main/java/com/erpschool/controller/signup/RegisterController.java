package com.erpschool.controller.signup;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.erpschool.apiresponse.ResponseObjectXML;
import com.erpschool.model.signup.UserSignupDetails;
import com.erpschool.service.signup.SignUpInterface;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class RegisterController {

	@Autowired
	private SignUpInterface signUpInterface;

	ResponseObjectXML<UserSignupDetails> responseObjectXML = new ResponseObjectXML<UserSignupDetails>();

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ResponseEntity<ResponseObjectXML<UserSignupDetails>> saveUser(@RequestBody UserSignupDetails userSignupDetails) {

		List<UserSignupDetails> addNewUserData = new ArrayList<UserSignupDetails>();
		Boolean rowStatus = signUpInterface.addNewUser(userSignupDetails);

		if (rowStatus == true) {
			responseObjectXML.setStatusCode(HttpStatus.OK.value());
			responseObjectXML.setMessage("User has been added successfully");
			responseObjectXML.setData(addNewUserData);
			
		} else {
			// TODO Auto-generated catch block
			responseObjectXML.setStatusCode(HttpStatus.BAD_REQUEST.value());
			responseObjectXML.setMessage("Errro in saving new user data");
			responseObjectXML.setData(null);	
		}
		return new ResponseEntity<ResponseObjectXML<UserSignupDetails>>(responseObjectXML, HttpStatus.OK);
	}
}

