package com.erpschool.repository.classes.studentclass;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.erpschool.model.classes.ClassDtls;

@Component
@Transactional
public class ClassesCustomQueryRepositoryImpl implements ClassesCustomQueryRepositoryInterface {
	
	@PersistenceContext
	EntityManager em;

	@Override
	public Integer addNewClassData(ClassDtls classDtls) {
		
		String addClassData = "Insert into classinfo(CLASS_NAME,ABBREVIATION,PRIORITY) values(?,?,?)";
		Query query = em.createNativeQuery(addClassData);
		query.setParameter(1,classDtls.getClassName());
		query.setParameter(2,classDtls.getAbbreviation());
		query.setParameter(3,classDtls.getPriority());
		
		int rowUpdate = query.executeUpdate();
		return rowUpdate;
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> getAllClasses() {
		
		String getAllClassData = "select * from classinfo";
		Query query = em.createNativeQuery(getAllClassData);
		List<Object[]> getAllClasses = query.getResultList();
		return getAllClasses;
	}

	@Override
	public Integer deleteClassData(Integer rowId) {
		
		 String delClassesData = "DELETE cd from classinfo cd where cd.ID = ?";
		 Query query = em.createNativeQuery(delClassesData);
		 query.setParameter(1,rowId);
		 Integer rowUpdate = query.executeUpdate();
		 return rowUpdate;
	}

	@Override
	public Integer editCLassData(ClassDtls editclassDtls) {
		
		System.out.println("editclassDtls...."+editclassDtls.getClassName());
		
		String editClassesData = "update classinfo set CLASS_NAME=?,ABBREVIATION=?,PRIORITY=?  where ID = ?";
		Query query = em.createNativeQuery(editClassesData);
		query.setParameter(1,editclassDtls.getClassName());
		query.setParameter(2,editclassDtls.getAbbreviation());
		query.setParameter(3,editclassDtls.getPriority());
		query.setParameter(4,editclassDtls.getId());
		
		int rowUpdate = query.executeUpdate();
		return rowUpdate;
		
	}
}
