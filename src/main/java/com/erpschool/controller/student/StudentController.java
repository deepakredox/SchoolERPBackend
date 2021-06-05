package com.erpschool.controller.student;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.erpschool.apiresponse.ResponseObjectXML;
import com.erpschool.model.student.StudentDtls;
import com.erpschool.service.student.StudentServiceInterface;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private StudentServiceInterface studServiceInterface;

	@Autowired
	ServletContext context;

	ResponseObjectXML<StudentDtls> responseObjectXML = new ResponseObjectXML<StudentDtls>();

	@PostMapping("/addstudent")
	public ResponseEntity<ResponseObjectXML<StudentDtls>> addStudent(@RequestParam("studInfo") String studInfo,
			@RequestParam("studImg") MultipartFile file) throws JsonMappingException, JsonProcessingException {

		List<StudentDtls> addStudentData = new ArrayList<StudentDtls>();

		Boolean saveStudentData = studServiceInterface.saveStudentData(studInfo, file);

		if (saveStudentData == true) {

			// response send back to UI
			responseObjectXML.setStatusCode(HttpStatus.OK.value());
			responseObjectXML.setMessage("New Student has been Added");
			responseObjectXML.setData(addStudentData);
		} else {
			responseObjectXML.setStatusCode(HttpStatus.BAD_REQUEST.value());
			responseObjectXML.setMessage("Error in saving student data");
			responseObjectXML.setData(null);
		}
		return new ResponseEntity<ResponseObjectXML<StudentDtls>>(responseObjectXML, HttpStatus.OK);
	}

	@GetMapping("getAllStudents")
	public ResponseEntity<ResponseObjectXML<StudentDtls>> getAllStudents() {

		List<StudentDtls> getStudentData = studServiceInterface.getAllStudentsList();

		try {

			if (getStudentData.size() == 0) {
				System.out.println("Size1" + getStudentData.size());
				responseObjectXML.setStatusCode(HttpStatus.NO_CONTENT.value());
				responseObjectXML.setMessage("No records found");
				responseObjectXML.setData(getStudentData);
			} else {
				// Get All Student Images
				studServiceInterface.getAllStudentImage(getStudentData);

				responseObjectXML.setStatusCode(HttpStatus.OK.value());
				responseObjectXML.setMessage("Student Data Fetch Successfully");
				responseObjectXML.setData(getStudentData);
			}
		} catch (Exception e) {
			responseObjectXML.setStatusCode(HttpStatus.BAD_REQUEST.value());
			responseObjectXML.setMessage("Error while getting the data");
			responseObjectXML.setData(null);
		}
		return new ResponseEntity<ResponseObjectXML<StudentDtls>>(responseObjectXML, HttpStatus.OK);
	}

	@DeleteMapping("/deleteStudent/{studAdmnNo}")
	public ResponseEntity<ResponseObjectXML<StudentDtls>> deleteStudentData(@PathVariable("studAdmnNo") List<Integer> studAdmnNo) {
		
		List<StudentDtls> delStudentData = new ArrayList<StudentDtls>();
		Boolean rowDeletedStatus = studServiceInterface.deleteStudentData(studAdmnNo);

		if (rowDeletedStatus == true) {

			// response send back to UI
			responseObjectXML.setStatusCode(HttpStatus.OK.value());
			responseObjectXML.setMessage("Student has been Deleted Successfully");
			responseObjectXML.setData(delStudentData);
		} else {
			responseObjectXML.setStatusCode(HttpStatus.BAD_REQUEST.value());
			responseObjectXML.setMessage("Error in delete student data");
			responseObjectXML.setData(null);
		}
		return new ResponseEntity<ResponseObjectXML<StudentDtls>>(responseObjectXML, HttpStatus.OK);
	}
}
