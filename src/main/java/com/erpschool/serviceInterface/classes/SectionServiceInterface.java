package com.erpschool.serviceInterface.classes;

import org.springframework.http.ResponseEntity;

import com.erpschool.apiresponse.ResponseObjectXML;
import com.erpschool.dto.classes.SectionDto;
import com.erpschool.model.classes.SectionDtls;

public interface SectionServiceInterface {

	ResponseEntity<ResponseObjectXML<SectionDto>> addNewSectionData(SectionDtls sectionDtls);

	ResponseEntity<ResponseObjectXML<SectionDto>> editSectionData(SectionDtls editSectionDtls);

	ResponseEntity<ResponseObjectXML<SectionDto>> deleteSectionData(Integer rowId);

	ResponseEntity<ResponseObjectXML<SectionDto>> getAllSection();

}

