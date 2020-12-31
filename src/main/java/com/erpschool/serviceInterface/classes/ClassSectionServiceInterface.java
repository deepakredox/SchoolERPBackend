package com.erpschool.serviceInterface.classes;

import org.springframework.http.ResponseEntity;

import com.erpschool.apiresponse.ResponseObjectXML;
import com.erpschool.dto.classes.ClassSectionDto;
import com.erpschool.model.classes.ClassSectionDtls;

public interface ClassSectionServiceInterface {

	ResponseEntity<ResponseObjectXML<ClassSectionDto>> saveClassSectionData(ClassSectionDtls classSectionDtls);

	ResponseEntity<ResponseObjectXML<ClassSectionDto>> editClassSectionData(ClassSectionDtls editClassSectionDtls);

	ResponseEntity<ResponseObjectXML<ClassSectionDto>> deleteClassSectionData(Integer rowId);

	ResponseEntity<ResponseObjectXML<ClassSectionDto>> getAllClassSectionData();
}

