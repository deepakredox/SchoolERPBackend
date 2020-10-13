package com.erpschool.serviceInterface.professor;

import com.erpschool.dto.professor.ProfessorDTO;
import com.erpschool.model.professor.ProfessorDtls;

public interface ProfessorServiceInterface {

	void addNewProfessor(ProfessorDtls addProfessorDtls);

	void editProfessor(ProfessorDtls editProfessorDtls);

	void deleteProfessor(ProfessorDtls delProfessorDtls);

	Iterable<ProfessorDTO> getAllProfessor();
}





