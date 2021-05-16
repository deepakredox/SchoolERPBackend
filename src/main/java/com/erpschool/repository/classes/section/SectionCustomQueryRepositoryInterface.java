package com.erpschool.repository.classes.section;

import java.util.List;

import com.erpschool.model.classes.SectionDtls;

public interface SectionCustomQueryRepositoryInterface {

	Integer addNewSectionData(SectionDtls sectionDtls);

	List<Object[]> getAllSection();

	Integer deleteSectionData(Integer rowId);

	Integer editSectionData(SectionDtls editSectionDtls);

}


