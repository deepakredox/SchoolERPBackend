package com.erpschool.serviceImpl.signin;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.erpschool.dao.signin.SigninDaoInterface;
import com.erpschool.dto.signin.UserLoginDTO;
import com.erpschool.serviceInterface.signin.SignInServiceInterface;

@Service
public class SignInServiceImpl implements SignInServiceInterface,UserDetailsService {

	@Autowired
    private	SigninDaoInterface signinDaoInterface;	


	public UserDetails getUserAccessInfo(String uname,String pass) throws UsernameNotFoundException {
		

		UserLoginDTO user = signinDaoInterface.getUserAccessInfo(uname);
		
		if(user != null)
		{
	      BCryptPasswordEncoder bcrypt= new BCryptPasswordEncoder();	
          boolean isPasswordMatches=bcrypt.matches(pass, user.getPassword());
          
          if(isPasswordMatches)
          {
        	System.out.println("Password Match now");
        	return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),new ArrayList<>());
          }  
          else
          {
        	  System.out.println("Password do not match");
        	  return null;
        	  //throw new UsernameNotFoundException("Password does not match: " + uname);
          }
		 }
		else {
			//throw new UsernameNotFoundException("User not found with username: " + uname);
			return null;
		}		
    }

	public UserDetails loadUserByUsername(String username) {
		
		UserLoginDTO user = signinDaoInterface.getUserAccessInfo(username);
		
		System.out.println("Hit query");
		if (user == null) {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
				new ArrayList<>());
	}
}
