package com.erpschool.serviceInterface.professor;

import org.springframework.http.ResponseEntity;

import com.erpschool.apiresponse.ResponseObjectXML;
import com.erpschool.dto.professor.ProfessorDTO;
import com.erpschool.model.professor.ProfessorDtls;

public interface ProfessorServiceInterface {

	ResponseEntity<ResponseObjectXML<ProfessorDTO>> addNewProfessorData(ProfessorDtls addProfessorDtls);

	ResponseEntity<ResponseObjectXML<ProfessorDTO>> editProfessorData(ProfessorDtls editProfessorDtls, Integer professorId);

	ResponseEntity<ResponseObjectXML<ProfessorDTO>> deleteProfessorData(Integer professorId);

	ResponseEntity<ResponseObjectXML<ProfessorDTO>> getAllProfessorData();
}





