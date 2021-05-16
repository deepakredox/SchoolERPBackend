package com.erpschool.repository.classes.classsection;

import java.util.List;

import com.erpschool.model.classes.ClassSectionDtls;

public interface ClassSectionCustomQueryInterface {

	Integer saveClassSectionData(ClassSectionDtls classSectionDtls);

	List<Object[]> getAllSection();

	Integer editClassSectionData(ClassSectionDtls editClassSectionDtls);

	Integer deleteClassSectionData(Integer rowId);

	List<Object[]> getAllClassSectionData();

	

}


