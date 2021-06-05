package com.erpschool.service.classes.section;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erpschool.dao.classes.section.SectionDaoInterface;
import com.erpschool.model.classes.SectionDtls;

@Service
public class SectionServicesImpl implements SectionServiceInterface {
	
	@Autowired
	private SectionDaoInterface sectionDaoInterface;

	@Override
	public Integer addNewSectionData(SectionDtls sectionDtls) {
		
		return sectionDaoInterface.addNewSectionData(sectionDtls);
	}

	@Override
	public Integer editSectionData(SectionDtls editSectionDtls) {
		
		return sectionDaoInterface.editSectionData(editSectionDtls);
	}

	@Override
	public Integer deleteSectionData(Integer rowId) {
		
		return sectionDaoInterface.deleteSectionData(rowId);
	}

	@Override
	public List<SectionDtls> getAllSection() {
		
		List<SectionDtls> sectionList = new ArrayList<SectionDtls>();
		SectionDtls sectionData = null;
		
		List<Object[]> getSectionData = sectionDaoInterface.getAllSection();
		
		for(Object[] obj : getSectionData)
		{
			sectionData = new SectionDtls();	
			sectionData.setId(Integer.parseInt(obj[0].toString()));
			sectionData.setSectionName(obj[1].toString());
			sectionData.setAbbreviation(obj[2].toString());
			sectionData.setPriority(Integer.parseInt(obj[3].toString()));
		  
			sectionList.add(sectionData);
		}
		return sectionList;
	}
}


