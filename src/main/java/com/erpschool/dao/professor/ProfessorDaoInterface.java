package com.erpschool.dao.professor;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.erpschool.dto.professor.AddProfessorDTO;

@Repository
public interface ProfessorDaoInterface extends CrudRepository<AddProfessorDTO,Integer> {
	
}
