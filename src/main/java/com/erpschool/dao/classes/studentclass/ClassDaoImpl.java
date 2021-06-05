package com.erpschool.dao.classes.studentclass;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.erpschool.model.classes.ClassDtls;
import com.erpschool.repository.classes.studentclass.ClassesCustomQueryRepositoryInterface;

@Component
@Transactional
public class ClassDaoImpl implements ClassDaoInterface {

	@Autowired
	private ClassesCustomQueryRepositoryInterface classesCustomQueryRepositoryInterface;
	
	@Override
	public Integer addNewClassData(ClassDtls classDtls) {
		return classesCustomQueryRepositoryInterface.addNewClassData(classDtls);
		
	}

	@Override
	public List<Object[]> getAllClasses() {
		
		return classesCustomQueryRepositoryInterface.getAllClasses();
		
	}

	@Override
	public Integer deleteClassData(Integer rowId) {

         return classesCustomQueryRepositoryInterface.deleteClassData(rowId);
	}

	@Override
	public Integer editCLassData(ClassDtls editclassDtls) {

       return classesCustomQueryRepositoryInterface.editCLassData(editclassDtls);
	}
}
