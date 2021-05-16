package com.erpschool.service.signin;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.erpschool.dao.signin.SigninDaoInterface;
import com.erpschool.model.signin.UserSignInDtls;

@Service
public class SignInServiceImpl implements SignInServiceInterface, UserDetailsService {

	@Autowired
	private SigninDaoInterface signinDaoInterface;

	public UserDetails getUserAccessInfo(String uname, String pass) throws UsernameNotFoundException {

		UserSignInDtls userExist = signinDaoInterface.getUserAccessInfo(uname);
		if(userExist != null)
		{
			String getUserEncryptPass = signinDaoInterface.getUserEncryptPass(uname);
			BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
			boolean isPasswordMatches = bcrypt.matches(pass, getUserEncryptPass);
			
			if (isPasswordMatches) {
				System.out.println("Password Match now");
				return new org.springframework.security.core.userdetails.User(uname, getUserEncryptPass,
						new ArrayList<>());
			} else {
				System.out.println("Password do not match");
				return null;
			}
		}
		else
		{
		  System.out.println("This User does not exist");
		   return null;
		}

	}

	public UserDetails loadUserByUsername(String username) {

		UserSignInDtls user = signinDaoInterface.getUserAccessInfo(username);

		System.out.println("Hit query");
		if (user == null) {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
				new ArrayList<>());
	}
}
