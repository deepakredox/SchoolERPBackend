package com.erpschool.serviceInterface.student;

import org.springframework.http.ResponseEntity;

import com.erpschool.apiresponse.ResponseObjectXML;
import com.erpschool.dto.student.StudentDTO;
import com.erpschool.model.student.StudentDtls;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

public interface StudentServiceInterface {

	ResponseEntity<ResponseObjectXML<StudentDTO>> addStudent(StudentDtls studDTls) throws JsonMappingException, JsonProcessingException;

}


