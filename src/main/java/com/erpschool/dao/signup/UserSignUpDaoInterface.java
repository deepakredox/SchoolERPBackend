package com.erpschool.dao.signup;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.erpschool.dto.signup.UserSignupDTO;

@Repository
public interface UserSignUpDaoInterface extends CrudRepository<UserSignupDTO, Integer> {

	UserSignupDTO findByEmail(String email);
}