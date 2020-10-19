package com.erpschool.controller.classes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.erpschool.apiresponse.ResponseObjectXML;
import com.erpschool.dto.classes.ClassesDto;
import com.erpschool.model.classes.ClassDtls;
import com.erpschool.serviceInterface.classes.ClassesServiceInterface;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/class")
public class ClassController {
	
	@Autowired
	private ClassesServiceInterface classesServiceInterface;
	
	
	@PostMapping("/addclass")
	public ResponseEntity<ResponseObjectXML<ClassesDto>> addClass(@RequestBody ClassDtls classDtls)
	{
		
		return classesServiceInterface.addNewClassData(classDtls);
	}
	
	
	@PostMapping("/editclass")
	public ResponseEntity<ResponseObjectXML<ClassesDto>> editClassData(@RequestBody ClassDtls editclassDtls)
	{
		return classesServiceInterface.editCLassData(editclassDtls);
	}
	
	@PostMapping("/deleteclass")
	public ResponseEntity<ResponseObjectXML<ClassesDto>> deleteClassData(@RequestBody ClassDtls deleteclassDtls)
	{
		return classesServiceInterface.deleteClassData(deleteclassDtls);
		
	}
	
	@GetMapping("getAllClasses")
	public ResponseEntity<ResponseObjectXML<ClassesDto>> getAllClasses()
	{
		return classesServiceInterface.getAllClasses();
	}
}
