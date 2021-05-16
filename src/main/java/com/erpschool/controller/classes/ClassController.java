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
import com.erpschool.model.classes.ClassDtls;
import com.erpschool.service.classes.studentclass.ClassesServiceInterface;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/class")
public class ClassController {

	@Autowired
	private ClassesServiceInterface classesServiceInterface;

	ResponseObjectXML<ClassDtls> responseObjectXML = new ResponseObjectXML<ClassDtls>();

	@PostMapping("/addclass")
	public ResponseEntity<ResponseObjectXML<ClassDtls>> addClass(@RequestBody ClassDtls classDtls) {
		
		List<ClassDtls> addClassesData = new ArrayList<ClassDtls>();
		Integer getRecordUpdate = classesServiceInterface.addNewClassData(classDtls);
		
		if (getRecordUpdate == 1) {
			responseObjectXML.setStatusCode(HttpStatus.OK.value());
			responseObjectXML.setMessage("New Class has been Added");
			responseObjectXML.setData(addClassesData);
		} else {
			// TODO Auto-generated catch block
			responseObjectXML.setStatusCode(HttpStatus.BAD_REQUEST.value());
			responseObjectXML.setMessage("Errro in saving data");
			responseObjectXML.setData(null);
		}
		return new ResponseEntity<ResponseObjectXML<ClassDtls>>(responseObjectXML, HttpStatus.OK);
	}

	@PutMapping("/editclass")
	public ResponseEntity<ResponseObjectXML<ClassDtls>> editClassData(@RequestBody ClassDtls editclassDtls) {
		
		System.out.println("Editing the class");
		List<ClassDtls> editClassesData = new ArrayList<ClassDtls>();
		Integer rowDeletedStatus =  classesServiceInterface.editCLassData(editclassDtls);
		if(rowDeletedStatus == 1)
		{
			responseObjectXML.setStatusCode(HttpStatus.OK.value());
			responseObjectXML.setMessage("Class Data Update Successfully");
			responseObjectXML.setData(editClassesData);	
		}
		else
		{
			responseObjectXML.setStatusCode(HttpStatus.BAD_REQUEST.value());
			responseObjectXML.setMessage("Error while edit the Class Data");
			responseObjectXML.setData(null);
		}
		return new ResponseEntity<ResponseObjectXML<ClassDtls>>(responseObjectXML, HttpStatus.OK);
	}

	@DeleteMapping("/deleteclass/{rowId}")
	public ResponseEntity<ResponseObjectXML<ClassDtls>> deleteClassData(@PathVariable("rowId") Integer rowId) {
		
		List<ClassDtls> classesDelData = new ArrayList<ClassDtls>();
		Integer rowDeletedStatus =  classesServiceInterface.deleteClassData(rowId);
		if(rowDeletedStatus == 1)
		{
			responseObjectXML.setStatusCode(HttpStatus.OK.value());
			responseObjectXML.setMessage("Classes Data delete Successfully");
			responseObjectXML.setData(classesDelData);
		}
		else
		{
			responseObjectXML.setStatusCode(HttpStatus.BAD_REQUEST.value());
			responseObjectXML.setMessage("Error while deleting the Class data");
			responseObjectXML.setData(null);
		}
		return new ResponseEntity<ResponseObjectXML<ClassDtls>>(responseObjectXML, HttpStatus.OK); 
	}

	@GetMapping("getAllClasses")
	public ResponseEntity<ResponseObjectXML<ClassDtls>> getAllClasses() {
		
		System.out.println("Get all Classes");
		List<ClassDtls> getClassesData = classesServiceInterface.getAllClasses();
		
		try {
			
			if (getClassesData.size() == 0) {
				System.out.println("Size1"+getClassesData.size());
				responseObjectXML.setStatusCode(HttpStatus.NO_CONTENT.value());
				responseObjectXML.setMessage("No records found");
				responseObjectXML.setData(getClassesData);
			}
			else
			{
				responseObjectXML.setStatusCode(HttpStatus.OK.value());
				responseObjectXML.setMessage("Data Fetch Successfully");
				responseObjectXML.setData(getClassesData);
			}
		} catch (Exception e) {
			responseObjectXML.setStatusCode(HttpStatus.BAD_REQUEST.value());
			responseObjectXML.setMessage("Error while getting the data");
			responseObjectXML.setData(null);
		}
		return new ResponseEntity<ResponseObjectXML<ClassDtls>>(responseObjectXML, HttpStatus.OK);
	}
}
