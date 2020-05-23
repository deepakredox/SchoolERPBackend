package com.erpschool.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.erpschool.model.UserDtls;
import com.erpschool.serviceInterface.UserDetailServiceInterface;

@RestController
public class RegisterController {
	
	@Autowired
	private UserDetailServiceInterface userDetailsService;

	@GetMapping("/hello-world")
	public String getHello() {
		Object un = SecurityContextHolder.getContext().getAuthentication().getPrincipal(); 
		System.out.println("Object...."+un);
		return "Hello World"; 
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ResponseEntity<?> saveUser(@RequestBody UserDtls user) throws Exception {
		return ResponseEntity.ok(userDetailsService.save(user));
	}
}
