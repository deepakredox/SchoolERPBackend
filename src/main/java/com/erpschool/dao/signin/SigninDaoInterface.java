package com.erpschool.dao.signin;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.erpschool.dto.signin.UserLoginDTO;

@Repository
public interface SigninDaoInterface extends CrudRepository<UserLoginDTO, Integer> {
	

	@Query("SELECT t FROM UserLoginDTO t where t.username = :uname")
	UserLoginDTO getUserAccessInfo(String uname);

}






