package com.erpschool.dao.signin;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

import com.erpschool.dto.signin.UserLoginDTO;

@Repository
public interface SigninDaoInterface extends JpaRepository<UserLoginDTO, Integer> {
	
	@Transactional
	@Query(value = "select * from logindtls t",nativeQuery = true)
	UserLoginDTO getUserAccessInfo(String uname);

}






