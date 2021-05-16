package com.erpschool.repository.classes.studentclass;

import java.util.List;

import com.erpschool.model.classes.ClassDtls;

public interface ClassesCustomQueryRepositoryInterface {

	Integer addNewClassData(ClassDtls classDtls);

	List<Object[]> getAllClasses();

	Integer deleteClassData(Integer rowId);

	Integer editCLassData(ClassDtls editclassDtls);

}


