package com.erpschool.controller.classes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
import com.erpschool.model.classes.SectionDtls;
import com.erpschool.service.classes.section.SectionServiceInterface;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/section")
public class SectionController {
	
	
	@Autowired
	private SectionServiceInterface sectionServiceInterface;
	
	ResponseObjectXML<SectionDtls> responseObjectXML = new ResponseObjectXML<SectionDtls>();
	
	@PostMapping("/addsection")
	public ResponseEntity<ResponseObjectXML<SectionDtls>> addSection(@RequestBody SectionDtls sectionDtls)
	{
		List<SectionDtls> addSectionData = new ArrayList<SectionDtls>();
		Integer getRecordUpdate = sectionServiceInterface.addNewSectionData(sectionDtls);
		
		if (getRecordUpdate == 1) {
			responseObjectXML.setStatusCode(HttpStatus.OK.value());
			responseObjectXML.setMessage("New Section has been Added");
			responseObjectXML.setData(addSectionData);
		} else {
			// TODO Auto-generated catch block
			responseObjectXML.setStatusCode(HttpStatus.BAD_REQUEST.value());
			responseObjectXML.setMessage("Errro in saving data");
			responseObjectXML.setData(null);
		}
		return new ResponseEntity<ResponseObjectXML<SectionDtls>>(responseObjectXML, HttpStatus.OK);
	}
	
	@PutMapping("/editsection")
	public ResponseEntity<ResponseObjectXML<SectionDtls>> editSectionData(@RequestBody SectionDtls editSectionDtls)
	{

		
		System.out.println("Editing the Section");
		List<SectionDtls> editSectionData = new ArrayList<SectionDtls>();
		Integer rowDeletedStatus =  sectionServiceInterface.editSectionData(editSectionDtls);
		if(rowDeletedStatus == 1)
		{
			responseObjectXML.setStatusCode(HttpStatus.OK.value());
			responseObjectXML.setMessage("Section Data Update Successfully");
			responseObjectXML.setData(editSectionData);	
		}
		else
		{
			responseObjectXML.setStatusCode(HttpStatus.BAD_REQUEST.value());
			responseObjectXML.setMessage("Error while edit the Section Data");
			responseObjectXML.setData(null);
		}
		return new ResponseEntity<ResponseObjectXML<SectionDtls>>(responseObjectXML, HttpStatus.OK);
	}
	
	@DeleteMapping("/deletesection/{rowId}")
	public ResponseEntity<ResponseObjectXML<SectionDtls>> deleteSectionData(@PathVariable("rowId") Integer rowId)
	{

		
		List<SectionDtls> sectionDelData = new ArrayList<SectionDtls>();
		Integer rowDeletedStatus =  sectionServiceInterface.deleteSectionData(rowId);
		if(rowDeletedStatus == 1)
		{
			responseObjectXML.setStatusCode(HttpStatus.OK.value());
			responseObjectXML.setMessage("Section Data delete Successfully");
			responseObjectXML.setData(sectionDelData);
		}
		else
		{
			responseObjectXML.setStatusCode(HttpStatus.BAD_REQUEST.value());
			responseObjectXML.setMessage("Error while deleting the Section data");
			responseObjectXML.setData(null);
		}
		return new ResponseEntity<ResponseObjectXML<SectionDtls>>(responseObjectXML, HttpStatus.OK); 
	}
	
	@GetMapping("/getallsection")
	public ResponseEntity<ResponseObjectXML<SectionDtls>> getAllSection()
	{

		
		System.out.println("Get all Section");
		List<SectionDtls> getSectionData = sectionServiceInterface.getAllSection();
		
		try {
			
			if (getSectionData.size() == 0) {
				System.out.println("Size1"+getSectionData.size());
				responseObjectXML.setStatusCode(HttpStatus.NO_CONTENT.value());
				responseObjectXML.setMessage("No records found");
				responseObjectXML.setData(getSectionData);
			}
			else
			{
				responseObjectXML.setStatusCode(HttpStatus.OK.value());
				responseObjectXML.setMessage("Data Fetch Successfully");
				responseObjectXML.setData(getSectionData);
			}
		} catch (Exception e) {
			responseObjectXML.setStatusCode(HttpStatus.BAD_REQUEST.value());
			responseObjectXML.setMessage("Error while getting the data");
			responseObjectXML.setData(null);
		} 
		return new ResponseEntity<ResponseObjectXML<SectionDtls>>(responseObjectXML, HttpStatus.OK);
	}
}
