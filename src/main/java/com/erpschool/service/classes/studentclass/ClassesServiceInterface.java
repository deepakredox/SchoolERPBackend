package com.erpschool.service.classes.studentclass;

import java.util.List;

import com.erpschool.model.classes.ClassDtls;

public interface ClassesServiceInterface {

	Integer addNewClassData(ClassDtls classDtls);

	Integer editCLassData(ClassDtls editclassDtls);

	Integer deleteClassData(Integer rowId);

	List<ClassDtls> getAllClasses();

}


