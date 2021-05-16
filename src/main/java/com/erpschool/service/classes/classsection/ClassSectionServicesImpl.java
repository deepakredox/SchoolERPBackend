package com.erpschool.service.classes.classsection;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erpschool.dao.classes.classsection.ClassSectionDaoInterface;
import com.erpschool.model.classes.ClassSectionDtls;


@Service
public class ClassSectionServicesImpl implements ClassSectionServiceInterface {
	
	@Autowired
	private ClassSectionDaoInterface classSectionDaoInterface;

	@Override
	public Integer saveClassSectionData(ClassSectionDtls classSectionDtls) {
		
		return classSectionDaoInterface.saveClassSectionData(classSectionDtls);
	}

	@Override
	public Integer editClassSectionData(ClassSectionDtls editClassSectionDtls) {

		return classSectionDaoInterface.editClassSectionData(editClassSectionDtls);
	}

	@Override
	public Integer deleteClassSectionData(Integer rowId) {

		return classSectionDaoInterface.deleteClassSectionData(rowId);
	
	}

	@Override
	public List<ClassSectionDtls> getAllClassSectionData() {
		
		List<ClassSectionDtls> classSectionList = new ArrayList<ClassSectionDtls>();
		List<Object[]> getClassSectionData = classSectionDaoInterface.getAllClassSectionData();
		ClassSectionDtls classSectionData = null;
		
		for(Object[] obj : getClassSectionData)
		{
		  classSectionData = new ClassSectionDtls();
		  classSectionData.setId(Integer.parseInt(obj[0].toString()));
		  classSectionData.setClassName(obj[1].toString());
		  classSectionData.setSectionName(obj[2].toString());
		  classSectionData.setClassTeacher(obj[3].toString());
		  classSectionData.setStrength(Integer.parseInt(obj[4].toString()));
		  
		  classSectionList.add(classSectionData);
		}
		return classSectionList;
	}
}
