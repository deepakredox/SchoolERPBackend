package com.erpschool.dao.student;

import java.util.List;
import java.util.Map;

import com.erpschool.model.student.StudentDtls;

public interface StudentDaoInterface {

	Integer saveStudentData(StudentDtls studDTls);

	List<Object[]> getAllStudentData();

	Integer deleteStudentData(Integer studAdmnNo);

	Map<String, Integer> getStudImageNameByAdmissionNo(List<Integer> studAdmnNo);

}



