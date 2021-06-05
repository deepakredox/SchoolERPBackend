package com.erpschool.service.classes.studentclass;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.erpschool.dao.classes.studentclass.ClassDaoInterface;
import com.erpschool.model.classes.ClassDtls;

@Service
public class ClassesServicesImpl implements ClassesServiceInterface {
	
	@Autowired
	private ClassDaoInterface classDaoInterface;

	@Override
	public Integer addNewClassData(ClassDtls classDtls) {
		
		return classDaoInterface.addNewClassData(classDtls);
	}

	@Override
	public Integer editCLassData(ClassDtls editclassDtls) {
		
		return classDaoInterface.editCLassData(editclassDtls);
	}

	@Override
	public Integer deleteClassData(Integer rowId) {
		
		return classDaoInterface.deleteClassData(rowId);
	}

	@Override
	public List<ClassDtls> getAllClasses() {
		
		List<ClassDtls> classesList = new ArrayList<ClassDtls>();
		ClassDtls classesData = null;
		
		List<Object[]> getClassesData = classDaoInterface.getAllClasses();
		
		for(Object[] obj : getClassesData)
		{
		  classesData = new ClassDtls();	
		  classesData.setId(Integer.parseInt(obj[0].toString()));
		  classesData.setClassName(obj[1].toString());
		  classesData.setAbbreviation(obj[2].toString());
		  classesData.setPriority(Integer.parseInt(obj[3].toString()));
		  
		  classesList.add(classesData);
		}
		return classesList;
	}
}


