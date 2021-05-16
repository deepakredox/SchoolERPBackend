package com.erpschool.service.classes.classsection;

import java.util.List;

import com.erpschool.model.classes.ClassSectionDtls;

public interface ClassSectionServiceInterface {

	Integer saveClassSectionData(ClassSectionDtls classSectionDtls);

	Integer editClassSectionData(ClassSectionDtls editClassSectionDtls);

	Integer deleteClassSectionData(Integer rowId);

	List<ClassSectionDtls> getAllClassSectionData();
}

