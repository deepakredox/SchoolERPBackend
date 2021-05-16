package com.erpschool.repository.classes.section;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.erpschool.model.classes.SectionDtls;

@Component
@Transactional
public class SectionCustomQueryRepositoryImpl implements SectionCustomQueryRepositoryInterface {
	
	@PersistenceContext
	EntityManager em;

	@Override
	public Integer addNewSectionData(SectionDtls sectionDtls) {
		
		String addSectionData = "Insert into sectioninfo(SECTION_NAME,ABBREVIATION,PRIORITY) values(?,?,?)";
		Query query = em.createNativeQuery(addSectionData);
		query.setParameter(1,sectionDtls.getSectionName());
		query.setParameter(2,sectionDtls.getAbbreviation());
		query.setParameter(3,sectionDtls.getPriority());
		
		int rowUpdate = query.executeUpdate();
		return rowUpdate;
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> getAllSection() {
		
		String getAllSectionData = "select * from sectioninfo";
		Query query = em.createNativeQuery(getAllSectionData);
		List<Object[]> getAllSection = query.getResultList();
		return getAllSection;
	}

	@Override
	public Integer deleteSectionData(Integer rowId) {
		
		 String delSectionData = "DELETE sd from sectioninfo sd where sd.ID = ?";
		 Query query = em.createNativeQuery(delSectionData);
		 query.setParameter(1, rowId);
		 Integer rowUpdate = query.executeUpdate();
		 return rowUpdate;
	}

	@Override
	public Integer editSectionData(SectionDtls editSectionDtls) {
		
		String editSectionData = "update sectioninfo set SECTION_NAME=?,ABBREVIATION=?,PRIORITY=?  where ID = ?";
		Query query = em.createNativeQuery(editSectionData);
		query.setParameter(1,editSectionDtls.getSectionName());
		query.setParameter(2,editSectionDtls.getAbbreviation());
		query.setParameter(3,editSectionDtls.getPriority());
		query.setParameter(4,editSectionDtls.getId());
		
		int rowUpdate = query.executeUpdate();
		return rowUpdate;
		
	}
}
