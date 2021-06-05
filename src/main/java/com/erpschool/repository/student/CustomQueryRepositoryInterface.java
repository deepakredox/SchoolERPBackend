package com.erpschool.repository.student;

import java.util.List;

import com.erpschool.model.student.StudentDtls;

public interface CustomQueryRepositoryInterface {

	Long saveStudentData(StudentDtls studDTls);

	Integer updateAdmissionNoByStudentId(StudentDtls studDTls);

	List<Object[]> getAllStudentRecord();

	Integer deleteStudentData(String studAdmnNo);

}






