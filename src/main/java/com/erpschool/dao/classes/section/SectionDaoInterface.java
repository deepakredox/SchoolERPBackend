package com.erpschool.dao.classes.section;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.erpschool.model.classes.SectionDtls;

@Repository
public interface SectionDaoInterface{

	Integer addNewSectionData(SectionDtls sectionDtls);

	List<Object[]> getAllSection();

	Integer deleteSectionData(Integer rowId);

	Integer editSectionData(SectionDtls editSectionDtls);

}




