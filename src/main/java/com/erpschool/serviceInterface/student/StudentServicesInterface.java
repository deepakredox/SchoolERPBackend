package com.erpschool.serviceInterface.student;

import org.springframework.http.ResponseEntity;

import com.erpschool.apiresponse.ResponseObjectXML;
import com.erpschool.dto.student.StudentDTO;
import com.erpschool.model.student.StudentDtls;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

public interface StudentServicesInterface {

	ResponseEntity<ResponseObjectXML<StudentDTO>> addStudent(StudentDtls studDTls) throws JsonMappingException, JsonProcessingException;

	ResponseEntity<ResponseObjectXML<StudentDTO>> getAllStudents();

	ResponseEntity<ResponseObjectXML<StudentDTO>> deleteStudentData(String rowId);

}





