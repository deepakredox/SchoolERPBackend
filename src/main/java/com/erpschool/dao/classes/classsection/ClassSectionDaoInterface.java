package com.erpschool.dao.classes.classsection;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.erpschool.model.classes.ClassSectionDtls;

@Repository
public interface ClassSectionDaoInterface {

	Integer saveClassSectionData(ClassSectionDtls classSectionDtls);

	Integer editClassSectionData(ClassSectionDtls editClassSectionDtls);

	Integer deleteClassSectionData(Integer rowId);

	List<Object[]> getAllClassSectionData();

}



