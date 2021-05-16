package com.erpschool.controller.signin;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.erpschool.apiresponse.AuthenticationJwtResponse;
import com.erpschool.apiresponse.ResponseWrapper;
import com.erpschool.config.JwtTokenUtil;
import com.erpschool.model.signin.UserSignInDtls;
import com.erpschool.service.signin.SignInServiceInterface;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class JwtAuthenticationController {

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private SignInServiceInterface userDetailServiceInterface;
	
	
	// Current Date and time
	Date date = new Date();
	SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MMMM-yyyy HH:mm:ss");  
	String strDate = simpleDateFormat.format(date); 	

	@RequestMapping(value = "/authenticateUser", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody UserSignInDtls authenticationRequest) throws Exception {

		System.out.println("Email........"+authenticationRequest.getUsername());
		System.out.println("Password........"+authenticationRequest.getPassword());
		
		ResponseWrapper responseWrapper  = new ResponseWrapper();
		
		final UserDetails userDetails = userDetailServiceInterface
				.getUserAccessInfo(authenticationRequest.getUsername(),authenticationRequest.getPassword());
		
		System.out.println("userDetails.........."+userDetails);
		if(userDetails == null) {
			
			responseWrapper.setTimestamp(strDate);
			responseWrapper.setStatusCode(HttpStatus.UNAUTHORIZED.value());
			responseWrapper.setStatusMessage(HttpStatus.UNAUTHORIZED);
			responseWrapper.setDesc("Username or Password do not match");
		}
		else {
			final String token = jwtTokenUtil.generateToken(userDetails);
			AuthenticationJwtResponse authenticationJwtResponse = new AuthenticationJwtResponse(token,"Bearer");
			responseWrapper.setTimestamp(strDate);
			responseWrapper.setStatusCode(HttpStatus.OK.value());
			responseWrapper.setStatusMessage(HttpStatus.OK);
			responseWrapper.setDesc("User Verified Successfully");
			responseWrapper.setAuthenticationJwtResponse(authenticationJwtResponse);
		}
		return ResponseEntity.ok(responseWrapper);
	}
}
