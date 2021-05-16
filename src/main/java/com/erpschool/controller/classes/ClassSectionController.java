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
import com.erpschool.model.classes.ClassSectionDtls;
import com.erpschool.service.classes.classsection.ClassSectionServiceInterface;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/class_section")
public class ClassSectionController {

	@Autowired
	private ClassSectionServiceInterface classSectionServiceInterface;

	ResponseObjectXML<ClassSectionDtls> responseObjectXML = new ResponseObjectXML<ClassSectionDtls>();

	@PostMapping("/saveClassSection")
	public ResponseEntity<ResponseObjectXML<ClassSectionDtls>> saveClassSectionData(@RequestBody ClassSectionDtls classSectionDtls) 
	{	
		List<ClassSectionDtls> addClassSectionData = new ArrayList<ClassSectionDtls>();
		Integer rowStatus = classSectionServiceInterface.saveClassSectionData(classSectionDtls);
		if (rowStatus == 1) {
			responseObjectXML.setStatusCode(HttpStatus.OK.value());
			responseObjectXML.setMessage("New Class-Section Data has been added");
			responseObjectXML.setData(addClassSectionData);
		} else {
			responseObjectXML.setStatusCode(HttpStatus.BAD_REQUEST.value());
			responseObjectXML.setMessage("Errro in saving data");
			responseObjectXML.setData(null);
		}
		return new ResponseEntity<ResponseObjectXML<ClassSectionDtls>>(responseObjectXML, HttpStatus.OK);
	}

	@PutMapping("/editClassSection")
	public ResponseEntity<ResponseObjectXML<ClassSectionDtls>> editClassSectionData(@RequestBody ClassSectionDtls editClassSectionDtls) {
		
		Integer rowStatus = classSectionServiceInterface.editClassSectionData(editClassSectionDtls);
		List<ClassSectionDtls> editClassesSectionData = new ArrayList<ClassSectionDtls>();
		
		if (rowStatus == 1) {
			responseObjectXML.setStatusCode(HttpStatus.OK.value());
			responseObjectXML.setMessage("Class Section Data Update Successfully");
			responseObjectXML.setData(editClassesSectionData);
			
		} else {
			responseObjectXML.setStatusCode(HttpStatus.BAD_REQUEST.value());
			responseObjectXML.setMessage("Error while edit the Class Section Data");
			responseObjectXML.setData(null);
		}
		return new ResponseEntity<ResponseObjectXML<ClassSectionDtls>>(responseObjectXML, HttpStatus.OK);
	}

	@DeleteMapping("/deleteClassSection/{rowId}")
	public ResponseEntity<ResponseObjectXML<ClassSectionDtls>> deleteClassSectionData(@PathVariable("rowId") Integer rowId) {
		
		List<ClassSectionDtls> classSectionDelData = new ArrayList<ClassSectionDtls>();
		Integer rowStatus = classSectionServiceInterface.deleteClassSectionData(rowId);		
		
		if (rowStatus == 1) {
			responseObjectXML.setStatusCode(HttpStatus.OK.value());
			responseObjectXML.setMessage("Class Section Data Update Successfully");
			responseObjectXML.setData(classSectionDelData);
		} else {
			responseObjectXML.setStatusCode(HttpStatus.BAD_REQUEST.value());
			responseObjectXML.setMessage("Error while edit the Class Section Data");
			responseObjectXML.setData(null);
		}
		return new ResponseEntity<ResponseObjectXML<ClassSectionDtls>>(responseObjectXML, HttpStatus.OK);
	}

	@GetMapping("/getAllClassSection")
	public ResponseEntity<ResponseObjectXML<ClassSectionDtls>> getAllClassSectionData() {
		
		System.out.println("getAllClassSectionData........");
		List<ClassSectionDtls> getClassSectionData = classSectionServiceInterface.getAllClassSectionData();
		System.out.println("getAllClassSectionData ....." +getClassSectionData);
		
		try {
			
			if (getClassSectionData.size() == 0) {
				responseObjectXML.setStatusCode(HttpStatus.NO_CONTENT.value());
				responseObjectXML.setMessage("No records found");
				responseObjectXML.setData(getClassSectionData);
			}
			else
			{
				responseObjectXML.setStatusCode(HttpStatus.OK.value());
				responseObjectXML.setMessage("Data Fetch Successfully");
				responseObjectXML.setData(getClassSectionData);
			}
		} catch (Exception e) {
			responseObjectXML.setStatusCode(HttpStatus.BAD_REQUEST.value());
			responseObjectXML.setMessage("Error while getting the Class Section Data");
			responseObjectXML.setData(null);
		}
		return new ResponseEntity<ResponseObjectXML<ClassSectionDtls>>(responseObjectXML, HttpStatus.OK);
	}
}
