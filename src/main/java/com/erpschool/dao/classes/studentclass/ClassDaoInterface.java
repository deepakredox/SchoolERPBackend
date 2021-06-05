package com.erpschool.dao.classes.studentclass;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.erpschool.model.classes.ClassDtls;

@Repository
public interface ClassDaoInterface{

	Integer addNewClassData(ClassDtls classDtls);

	List<Object[]> getAllClasses();

	Integer deleteClassData(Integer rowId);

	Integer editCLassData(ClassDtls editclassDtls);

}




