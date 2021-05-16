package com.erpschool.dao.classes.section;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.erpschool.model.classes.SectionDtls;
import com.erpschool.repository.classes.section.SectionCustomQueryRepositoryInterface;

@Component
@Transactional
public class SectionDaoImpl implements SectionDaoInterface {

	@Autowired
	private SectionCustomQueryRepositoryInterface sectionCustomQueryRepositoryInterface;
	
	@Override
	public Integer addNewSectionData(SectionDtls sectionDtls) {
		return sectionCustomQueryRepositoryInterface.addNewSectionData(sectionDtls);
		
	}

	@Override
	public List<Object[]> getAllSection() {
		
		return sectionCustomQueryRepositoryInterface.getAllSection();
		
	}

	@Override
	public Integer deleteSectionData(Integer rowId) {

         return sectionCustomQueryRepositoryInterface.deleteSectionData(rowId);
	}

	@Override
	public Integer editSectionData(SectionDtls editSectionDtls) {

       return sectionCustomQueryRepositoryInterface.editSectionData(editSectionDtls);
	}
}
