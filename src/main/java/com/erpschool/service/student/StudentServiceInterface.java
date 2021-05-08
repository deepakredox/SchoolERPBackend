package com.erpschool.service.student;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.erpschool.model.student.StudentDtls;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

public interface StudentServiceInterface {

	Boolean saveStudentData(String studInfo, MultipartFile file) throws JsonMappingException, JsonProcessingException;

	List<StudentDtls> getAllStudents();

	void getAllStudentImage(List<StudentDtls> studentDataList);

}






