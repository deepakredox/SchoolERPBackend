package com.erpschool.dao.student;

import java.util.List;

import com.erpschool.model.student.StudentDtls;

public interface StudentDaoInterface {

	Integer saveStudentData(StudentDtls studDTls);

	List<Object[]> getAllStudentData();

	Integer deleteStudentData(String studAdmnNo);

}



