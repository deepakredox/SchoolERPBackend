package com.erpschool.repository.student;

import java.util.List;
import java.util.Map;

import com.erpschool.model.student.StudentDtls;

public interface StudentCustomQueryRepositoryInterface {

	Long saveStudentData(StudentDtls studDTls);

	Integer updateAdmissionNoByStudentId(StudentDtls studDTls);

	List<Object[]> getAllStudentRecord();

	Integer deleteStudentData(Integer studAdmnNo);

	Map<String, Integer> getStudImageNameByAdmissionNo(List<Integer> studAdmnNo);

}






