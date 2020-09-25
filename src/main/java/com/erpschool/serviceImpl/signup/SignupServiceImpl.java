package com.erpschool.serviceImpl.signup;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.erpschool.dao.signup.UserSignUpDaoInterface;
import com.erpschool.dto.signin.UserLoginDTO;
import com.erpschool.dto.signup.UserSignupDTO;
import com.erpschool.model.signup.UserSignupDetails;
import com.erpschool.serviceInterface.signup.SignUpInterface;

@Service
@Component
@Transactional	
public class SignupServiceImpl implements SignUpInterface{
	
	
	@Autowired
    private	UserSignUpDaoInterface userSignUpDaoInterface;	
	
	@Autowired
	private PasswordEncoder bcryptEncoder;
	
	@PersistenceContext
	private EntityManager entitymanager;


	
	@Override
	public UserSignupDTO addNewUser(UserSignupDetails userSignupDetails) {
		
		UserSignupDTO user = userSignUpDaoInterface.findByEmail(userSignupDetails.getEmail());
		try 
		{
			if (user == null) {
				UserSignupDTO userSignupDTO = new UserSignupDTO();
				userSignupDTO.setUsername(userSignupDetails.getUsername());
				userSignupDTO.setEmail(userSignupDetails.getEmail());
				userSignupDTO.setPass(bcryptEncoder.encode(userSignupDetails.getPassword()));
				userSignupDTO.setCpassword(userSignupDetails.getCpassword());
				userSignUpDaoInterface.save(userSignupDTO);
				
				UserLoginDTO adduserdto = new UserLoginDTO();
				adduserdto.setUsername(userSignupDTO.getUsername());
				adduserdto.setPassword(userSignupDTO.getPass());
				entitymanager.persist(adduserdto);
				
				return user;
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return user;
		}
		return user;
	}

}
