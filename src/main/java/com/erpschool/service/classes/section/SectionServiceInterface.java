package com.erpschool.service.classes.section;

import java.util.List;

import com.erpschool.model.classes.SectionDtls;

public interface SectionServiceInterface {

	Integer addNewSectionData(SectionDtls sectionDtls);

	Integer editSectionData(SectionDtls editSectionDtls);

	Integer deleteSectionData(Integer rowId);

	List<SectionDtls> getAllSection();

}


