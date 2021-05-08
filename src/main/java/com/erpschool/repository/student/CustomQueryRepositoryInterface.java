package com.erpschool.repository.student;

import java.util.List;

import com.erpschool.model.student.StudentDtls;

public interface CustomQueryRepositoryInterface {

	Long saveStudentData(StudentDtls studDTls);

	Integer updateStudentByAdmissionNo(StudentDtls studDTls);

	List<StudentDtls> getAllStudentRecord();

}




