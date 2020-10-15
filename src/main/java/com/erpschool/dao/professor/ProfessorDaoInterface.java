package com.erpschool.dao.professor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.erpschool.dto.professor.ProfessorDTO;

@Repository
public interface ProfessorDaoInterface extends JpaRepository<ProfessorDTO,Integer> {
	
}
