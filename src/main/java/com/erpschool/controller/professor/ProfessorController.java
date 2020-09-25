package com.erpschool.controller.professor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.erpschool.model.professor.AddProfessorDtls;
import com.erpschool.serviceInterface.professor.ProfessorServiceInterface;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ProfessorController {
	
	@Autowired
	private ProfessorServiceInterface addProfessorServiceInterface;
	
	@PostMapping("/addProfessor")
	public void addnewProfessor(@RequestBody AddProfessorDtls addProfessorDtls)
	{
		System.out.println("AddProfessorDtls.."+addProfessorDtls);
		addProfessorServiceInterface.addNewProfessor(addProfessorDtls);
	}
}


