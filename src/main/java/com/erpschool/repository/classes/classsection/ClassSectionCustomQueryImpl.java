package com.erpschool.repository.classes.classsection;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.erpschool.model.classes.ClassSectionDtls;

@Component
@Transactional
public class ClassSectionCustomQueryImpl implements ClassSectionCustomQueryInterface {
	
	@PersistenceContext
	EntityManager em;
	
	
	@Override
	public Integer saveClassSectionData(ClassSectionDtls classSectionDtls) {
		
		String addClassSectionData = "Insert into class_section_info(CLASS_NAME,SECTION_NAME,CLASS_TEACHER,STRENGTH) values(?,?,?,?)";
		Query query = em.createNativeQuery(addClassSectionData);
		query.setParameter(1,classSectionDtls.getClassName());
		query.setParameter(2,classSectionDtls.getSectionName());
		query.setParameter(3,classSectionDtls.getClassTeacher());
		query.setParameter(4,classSectionDtls.getStrength());
		
		Integer rowStatus = query.executeUpdate();
		return rowStatus;
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
	public Integer editClassSectionData(ClassSectionDtls editClassSectionDtls) {
		String editClassSectionData = "update class_section_info set CLASS_NAME=?,SECTION_NAME=?,CLASS_TEACHER=?,STRENGTH=?  where ID = ?";
		Query query = em.createNativeQuery(editClassSectionData);
		query.setParameter(1,editClassSectionDtls.getClassName());
		query.setParameter(2,editClassSectionDtls.getSectionName());
		query.setParameter(3,editClassSectionDtls.getClassTeacher());
		query.setParameter(4,editClassSectionDtls.getStrength());
		query.setParameter(5,editClassSectionDtls.getId());
		
		int rowUpdate = query.executeUpdate();
		return rowUpdate;
	}

	@Override
	public Integer deleteClassSectionData(Integer rowId) {
		String delClassSectionData = "DELETE csd from class_section_info csd where csd.ID = ?";
		 Query query = em.createNativeQuery(delClassSectionData);
		 query.setParameter(1,rowId);
		 Integer rowUpdate = query.executeUpdate();
		 return rowUpdate;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> getAllClassSectionData() {
		
		String getAllClassSectionData = "select * from class_section_info";
		Query query = em.createNativeQuery(getAllClassSectionData);
		List<Object[]> getAllClassSection = query.getResultList();
		return getAllClassSection;
	}
}
