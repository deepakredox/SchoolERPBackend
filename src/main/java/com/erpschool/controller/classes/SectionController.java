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
import com.erpschool.dto.classes.SectionDto;
import com.erpschool.model.classes.SectionDtls;
import com.erpschool.serviceInterface.classes.SectionServiceInterface;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/section")
public class SectionController {
	
	
	@Autowired
	private SectionServiceInterface sectionServiceInterface;
	
	@PostMapping("/addsection")
	public ResponseEntity<ResponseObjectXML<SectionDto>> addSection(@RequestBody SectionDtls sectionDtls)
	{
	  return sectionServiceInterface.addNewSectionData(sectionDtls);
	}
	
	@PutMapping("/editsection")
	public ResponseEntity<ResponseObjectXML<SectionDto>> editSectionData(@RequestBody SectionDtls editSectionDtls)
	{
		return sectionServiceInterface.editSectionData(editSectionDtls);
	}
	
	@DeleteMapping("/deletesection/{rowId}")
	public ResponseEntity<ResponseObjectXML<SectionDto>> deleteSectionData(@PathVariable("rowId") Integer rowId)
	{
		return sectionServiceInterface.deleteSectionData(rowId);
	}
	
	@GetMapping("/getallsection")
	public ResponseEntity<ResponseObjectXML<SectionDto>> getAllSection()
	{
		System.out.println("Get all data");
		return sectionServiceInterface.getAllSection();
	}
}
