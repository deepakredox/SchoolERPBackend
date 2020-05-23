package com.erpschool.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.erpschool.model.UserDTO;

@Repository
public interface UserDaoInterface extends CrudRepository<UserDTO, Integer> {

	UserDTO findByEmail(String email);
}




