package com.erpschool.controller.professor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.erpschool.model.professor.ProfessorDtls;
import com.erpschool.serviceInterface.professor.ProfessorServiceInterface;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ProfessorController {
	
	@Autowired
	private ProfessorServiceInterface professorServiceInterface;
	
	@PostMapping("/addProfessor")
	public void addnewProfessor(@RequestBody ProfessorDtls addProfessorDtls)
	{
		System.out.println("AddProfessorDtls.."+addProfessorDtls);
		professorServiceInterface.addNewProfessor(addProfessorDtls);
	}
	
	@PostMapping("/editProfessor")
	public void editProfessor(@RequestBody ProfessorDtls editProfessorDtls) 
	{
	  	
	  System.out.println("Edit the Professor");	
	  professorServiceInterface.editProfessor(editProfessorDtls);
	}
	
	@PostMapping("/deleteProfessor")
	public void deleteProfessor(@RequestBody ProfessorDtls delProfessorDtls) 
	{
	  	
	  System.out.println("Delete the Professor");	
	  professorServiceInterface.deleteProfessor(delProfessorDtls);
	}
}


