package com.erpschool.repository.signup;

import java.math.BigInteger;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.erpschool.model.signup.UserSignupDetails;

@Component
@Transactional
public class UserSignUpCustomQueryImpl implements UserSignUpCustomQueryInterface {

	@PersistenceContext
	EntityManager em;

	@Autowired
	private PasswordEncoder bcryptEncoder;

	@Override
	public Boolean addNewSignUpUser(UserSignupDetails userSignupDetails) {

		Boolean rowStatus = false;
		String getUserEmail = "select count(usr.EMAIL) from signupdtls usr where usr.EMAIL = ?";
		Query query = em.createNativeQuery(getUserEmail);
		query.setParameter(1, userSignupDetails.getEmail());
		BigInteger rowMatch = (BigInteger) query.getSingleResult();
		if (rowMatch.intValue() == 0) {
			Integer rowStatusData = addNewUser(userSignupDetails);
			if(rowStatusData == 1)
			{
				rowStatus = true;
			}
		}
		return rowStatus;

	}

	public Integer addNewUser(UserSignupDetails userSignupDetails) {

		String addNewUser = "insert into signupdtls(USERNAME,EMAIL,PASSWORD,CONFIRM_PASSWORD) values(?,?,?,?)";
		Query query = em.createNativeQuery(addNewUser);
		query.setParameter(1, userSignupDetails.getUsername());
		query.setParameter(2, userSignupDetails.getEmail());
		query.setParameter(3, bcryptEncoder.encode(userSignupDetails.getPassword()));
		query.setParameter(4, userSignupDetails.getCpassword());

		int rowUpdate = query.executeUpdate();
		Integer rowData = 0;
		
		long lastId = ((BigInteger) em.createNativeQuery("SELECT LAST_INSERT_ID()").getSingleResult()).longValue();
		String getUserEncryptPass = "select PASSWORD from signupdtls stud where stud.ID =" +lastId;
		String getUserEncryptPassword = (String) em.createNativeQuery(getUserEncryptPass).getSingleResult();

		if (rowUpdate == 1) {
			rowData = addNewUserInSign(userSignupDetails.getUsername(), getUserEncryptPassword);
		}
		return rowData;
	}

	private Integer addNewUserInSign(String username, String password) {
		String addNewUser = "insert into logindtls(USERNAME,PASSWORD) values(?,?)";
		Query query = em.createNativeQuery(addNewUser);
		query.setParameter(1, username);
		query.setParameter(2, password);

		Integer rowStatus = query.executeUpdate();
        return rowStatus;
	}
}
