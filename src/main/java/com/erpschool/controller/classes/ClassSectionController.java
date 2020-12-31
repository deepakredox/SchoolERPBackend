package com.erpschool.controller.classes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.erpschool.apiresponse.ResponseObjectXML;
import com.erpschool.dto.classes.ClassSectionDto;
import com.erpschool.model.classes.ClassSectionDtls;
import com.erpschool.serviceInterface.classes.ClassSectionServiceInterface;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/class_section")
public class ClassSectionController {

	@Autowired
	private ClassSectionServiceInterface classSectionServiceInterface;

	@PostMapping("/saveclasssection")
	public ResponseEntity<ResponseObjectXML<ClassSectionDto>> saveClassSectionData(@RequestBody ClassSectionDtls classSectionDtls) 
	{
		return classSectionServiceInterface.saveClassSectionData(classSectionDtls);
	}

	@PutMapping("/editClassSection")
	public ResponseEntity<ResponseObjectXML<ClassSectionDto>> editClassData(@RequestBody ClassSectionDtls editClassSectionDtls) 
	{
		return classSectionServiceInterface.editClassSectionData(editClassSectionDtls);
	}

	@DeleteMapping("/deleteClassSection/{rowId}")
	public ResponseEntity<ResponseObjectXML<ClassSectionDto>> deleteClassData(@PathVariable("rowId") Integer rowId) 
	{
		return classSectionServiceInterface.deleteClassSectionData(rowId);
	}

	@GetMapping("getAllClassSection")
	public ResponseEntity<ResponseObjectXML<ClassSectionDto>> getAllClasses() 
	{
		return classSectionServiceInterface.getAllClassSectionData();
	}
}
