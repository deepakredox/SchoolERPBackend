package com.erpschool.serviceImpl.classes;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.erpschool.apiresponse.ResponseObjectXML;
import com.erpschool.dao.classes.SectionDaoInterface;
import com.erpschool.dto.classes.SectionDto;
import com.erpschool.model.classes.SectionDtls;
import com.erpschool.serviceInterface.classes.SectionServiceInterface;

@Service
public class SectionServicesImpl implements SectionServiceInterface {
	
	@Autowired
	private SectionDaoInterface sectionDaoInterface;
	
	ResponseObjectXML<SectionDto> responseObjectXML = new ResponseObjectXML<SectionDto>();

	@Override
	public ResponseEntity<ResponseObjectXML<SectionDto>> addNewSectionData(SectionDtls sectionDtls) {
		
		List<SectionDto> addsectionlist = new ArrayList<SectionDto>();
		
		try {
			SectionDto sectionDto = new SectionDto();
			
			sectionDto.setSectionName(sectionDtls.getSectionName());
			sectionDto.setAbbreviation(sectionDtls.getAbbreviation());
			sectionDto.setPriority(sectionDtls.getPriority());
			
			sectionDaoInterface.save(sectionDto);
			
			responseObjectXML.setStatusCode(HttpStatus.OK.value());
			responseObjectXML.setMessage("New Section has been Added");
			responseObjectXML.setData(addsectionlist);
			
		} catch (Exception e) {
			
			responseObjectXML.setStatusCode(HttpStatus.BAD_REQUEST.value());
			responseObjectXML.setMessage("Errro in saving data");
			responseObjectXML.setData(null);
			return new ResponseEntity<ResponseObjectXML<SectionDto>>(responseObjectXML,HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<ResponseObjectXML<SectionDto>>(responseObjectXML,HttpStatus.OK);
	}

	@Override
	public ResponseEntity<ResponseObjectXML<SectionDto>> editSectionData(SectionDtls editSectionDtls) {
		
		SectionDto editSectionDto = new SectionDto(); 
		List<SectionDto> editSectionList = new ArrayList<SectionDto>();
 		
		try {
			
			Optional<SectionDto> sectionDTOData =  sectionDaoInterface.findById(editSectionDtls.getId());
			if(sectionDTOData.isPresent())
			{
			 editSectionDto.setId(editSectionDtls.getId());
			 editSectionDto.setSectionName(editSectionDtls.getSectionName());
			 editSectionDto.setAbbreviation(editSectionDtls.getAbbreviation());
			 editSectionDto.setPriority(editSectionDtls.getPriority());
			 
			 sectionDaoInterface.save(editSectionDto);
			 
			 // Sending Response
			 responseObjectXML.setStatusCode(HttpStatus.OK.value());
			 responseObjectXML.setMessage("Section Data Update Successfully");
			 responseObjectXML.setData(editSectionList);
			}
		} catch (Exception e) {
			responseObjectXML.setStatusCode(HttpStatus.BAD_REQUEST.value());
			responseObjectXML.setMessage("Error while edit the Section Data");
			responseObjectXML.setData(null);
			return new ResponseEntity<ResponseObjectXML<SectionDto>>(responseObjectXML,HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<ResponseObjectXML<SectionDto>>(responseObjectXML,HttpStatus.OK);
	}

	@Override
	public ResponseEntity<ResponseObjectXML<SectionDto>> deleteSectionData(Integer rowId) {
		
		List<SectionDto> delSectionData = new ArrayList<SectionDto>();

		try {
			// Delete the Professor Details
			sectionDaoInterface.deleteById(rowId);

			// Sending response
			responseObjectXML.setStatusCode(HttpStatus.OK.value());
			responseObjectXML.setMessage("Classes Data delete Successfully");
			responseObjectXML.setData(delSectionData);
			return new ResponseEntity<ResponseObjectXML<SectionDto>>(responseObjectXML, HttpStatus.OK);

		} catch (Exception e) {
			responseObjectXML.setStatusCode(HttpStatus.BAD_REQUEST.value());
			responseObjectXML.setMessage("Error while deleting the Section data");
			responseObjectXML.setData(null);
			return new ResponseEntity<ResponseObjectXML<SectionDto>>(responseObjectXML, HttpStatus.BAD_REQUEST);
		}
	}

	@Override
	public ResponseEntity<ResponseObjectXML<SectionDto>> getAllSection() {
		
		System.out.println("hjgjgj");

		List<SectionDto> sectionDataList = new ArrayList<SectionDto>();
		
		try {
			List<SectionDto> classesDTO = sectionDaoInterface.findAll();
			
			for (SectionDto sectionData : classesDTO) {
				sectionDataList.add(sectionData);
			}
			
			System.out.println("Size"+sectionDataList.size());
			
			if (sectionDataList.size() == 0) {
				System.out.println("Size1"+sectionDataList.size());
				responseObjectXML.setStatusCode(HttpStatus.NOT_FOUND.value());
				responseObjectXML.setMessage("No records found");
				responseObjectXML.setData(sectionDataList);
				return new ResponseEntity<ResponseObjectXML<SectionDto>>(responseObjectXML, HttpStatus.OK);
			}
			else
			{
				responseObjectXML.setStatusCode(HttpStatus.OK.value());
				responseObjectXML.setMessage("Data Fetch Successfully");
				responseObjectXML.setData(sectionDataList);
				return new ResponseEntity<ResponseObjectXML<SectionDto>>(responseObjectXML, HttpStatus.OK);
			}
		} catch (Exception e) {
			responseObjectXML.setStatusCode(HttpStatus.BAD_REQUEST.value());
			responseObjectXML.setMessage("Error while getting the data");
			responseObjectXML.setData(null);
			return new ResponseEntity<ResponseObjectXML<SectionDto>>(responseObjectXML,HttpStatus.BAD_REQUEST);
		}
	}
}
