package com.erpschool.serviceImpl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.erpschool.dao.UserDaoInterface;
import com.erpschool.model.UserDTO;
import com.erpschool.model.UserDtls;
import com.erpschool.serviceInterface.UserDetailServiceInterface;

@Service
public class UserDetailServiceImpl implements UserDetailServiceInterface,UserDetailsService {

	@Autowired
    private	UserDaoInterface userDaoInterface;	
	
	@Autowired
	private PasswordEncoder bcryptEncoder;

	@Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
		UserDTO user = userDaoInterface.findByEmail(s);
		System.out.println("Hit query");
		if (user == null) {
			throw new UsernameNotFoundException("User not found with username: " + s);
		}
		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(),
				new ArrayList<>());
    }

	@Override
	public UserDTO save(UserDtls user) {
		
		UserDTO newUser = new UserDTO();
		newUser.setEmail(user.getEmail());
		newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
		return userDaoInterface.save(newUser);
	}
}
