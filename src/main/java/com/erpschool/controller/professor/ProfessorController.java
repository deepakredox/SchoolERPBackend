package com.erpschool.controller.professor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.erpschool.apiresponse.ResponseObjectXML;
import com.erpschool.dto.professor.ProfessorDTO;
import com.erpschool.model.professor.ProfessorDtls;
import com.erpschool.serviceInterface.professor.ProfessorServiceInterface;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/professor")
public class ProfessorController {

	@Autowired
	private ProfessorServiceInterface professorServiceInterface;

	

	@PostMapping("/addProfessor")
	public ResponseEntity<ResponseObjectXML<ProfessorDTO>> addnewProfessorData(@RequestBody ProfessorDtls addProfessorDtls) {
		
		return professorServiceInterface.addNewProfessorData(addProfessorDtls);
	}

	@PostMapping("/editProfessor")
	public ResponseEntity<ResponseObjectXML<ProfessorDTO>> editProfessorData(@RequestBody ProfessorDtls editProfessorDtls) {
		
		return professorServiceInterface.editProfessorData(editProfessorDtls);
		
	}

	@PostMapping("/deleteProfessor")
	public ResponseEntity<ResponseObjectXML<ProfessorDTO>> deleteProfessorData(@RequestBody ProfessorDtls delProfessorDtls) {
		
		return professorServiceInterface.deleteProfessorData(delProfessorDtls);	
	}

	@GetMapping("/getAllProfessor")
	public ResponseEntity<ResponseObjectXML<ProfessorDTO>> getAllProfessorData() {

		return professorServiceInterface.getAllProfessorData();
	}
}

