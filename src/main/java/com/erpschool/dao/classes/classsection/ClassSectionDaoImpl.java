package com.erpschool.dao.classes.classsection;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.erpschool.model.classes.ClassSectionDtls;
import com.erpschool.repository.classes.classsection.ClassSectionCustomQueryInterface;

@Component
@Transactional
public class ClassSectionDaoImpl implements ClassSectionDaoInterface {
	
	@Autowired
	private ClassSectionCustomQueryInterface classSectionCustomQueryInterface;

	@Override
	public Integer saveClassSectionData(ClassSectionDtls classSectionDtls) {
		return classSectionCustomQueryInterface.saveClassSectionData(classSectionDtls);
	}

	@Override
	public Integer editClassSectionData(ClassSectionDtls editClassSectionDtls) {
		
		return classSectionCustomQueryInterface.editClassSectionData(editClassSectionDtls);
	}

	@Override
	public Integer deleteClassSectionData(Integer rowId) {
		return classSectionCustomQueryInterface.deleteClassSectionData(rowId);
	}

	@Override
	public List<Object[]> getAllClassSectionData() {
		// TODO Auto-generated method stub
		return classSectionCustomQueryInterface.getAllClassSectionData();
	}
}
