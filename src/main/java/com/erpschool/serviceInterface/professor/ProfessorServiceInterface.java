package com.erpschool.serviceInterface.professor;

import com.erpschool.model.professor.ProfessorDtls;

public interface ProfessorServiceInterface {

	void addNewProfessor(ProfessorDtls addProfessorDtls);

	void editProfessor(ProfessorDtls editProfessorDtls);

	void deleteProfessor(ProfessorDtls delProfessorDtls);
}





