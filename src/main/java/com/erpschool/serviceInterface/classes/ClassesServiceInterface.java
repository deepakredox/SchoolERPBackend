package com.erpschool.serviceInterface.classes;

import org.springframework.http.ResponseEntity;

import com.erpschool.apiresponse.ResponseObjectXML;
import com.erpschool.dto.classes.ClassesDto;
import com.erpschool.model.classes.ClassDtls;

public interface ClassesServiceInterface {

	ResponseEntity<ResponseObjectXML<ClassesDto>> addNewClassData(ClassDtls classDtls);

	ResponseEntity<ResponseObjectXML<ClassesDto>> editCLassData(ClassDtls editclassDtls);

	ResponseEntity<ResponseObjectXML<ClassesDto>> deleteClassData(Integer rowId);

	ResponseEntity<ResponseObjectXML<ClassesDto>> getAllClasses();

}


