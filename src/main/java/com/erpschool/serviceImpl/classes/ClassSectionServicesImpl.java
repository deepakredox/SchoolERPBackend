package com.erpschool.serviceImpl.classes;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.erpschool.apiresponse.ResponseObjectXML;
import com.erpschool.dao.classes.ClassSectionDaoInterface;
import com.erpschool.dto.classes.ClassSectionDto;
import com.erpschool.model.classes.ClassSectionDtls;
import com.erpschool.serviceInterface.classes.ClassSectionServiceInterface;

@Service
public class ClassSectionServicesImpl implements ClassSectionServiceInterface {
	
	@Autowired
	private ClassSectionDaoInterface classSectionDaoInterface;
	
	ResponseObjectXML<ClassSectionDto> responseObjectXML = new ResponseObjectXML<ClassSectionDto>();

	@Override
	public ResponseEntity<ResponseObjectXML<ClassSectionDto>> saveClassSectionData(ClassSectionDtls classSectionDtls) {
		
		List<ClassSectionDto> addClassSectionData = new ArrayList<ClassSectionDto>();
		
		try {
			ClassSectionDto classSectionDto =  new ClassSectionDto();
			classSectionDto.setClassName(classSectionDtls.getClassName());
			classSectionDto.setSectionName(classSectionDtls.getSectionName());
			classSectionDto.setClassTeacher(classSectionDtls.getClassTeacher());
			classSectionDto.setStrength(classSectionDtls.getStrength());
			
			classSectionDaoInterface.save(classSectionDto);
			
			responseObjectXML.setStatusCode(HttpStatus.OK.value());
			responseObjectXML.setMessage("New Class-Section Data has been added");
			responseObjectXML.setData(addClassSectionData);
			
			return new ResponseEntity<ResponseObjectXML<ClassSectionDto>>(responseObjectXML,HttpStatus.OK);
		} catch (Exception e) {
			responseObjectXML.setStatusCode(HttpStatus.BAD_REQUEST.value());
			responseObjectXML.setMessage("Errro in saving data");
			responseObjectXML.setData(null);
			return new ResponseEntity<ResponseObjectXML<ClassSectionDto>>(responseObjectXML, HttpStatus.BAD_REQUEST);
		}
	}

	@Override
	public ResponseEntity<ResponseObjectXML<ClassSectionDto>> editClassSectionData(ClassSectionDtls editClassSectionDtls) {

		
		ClassSectionDto editClassSectionDto = new ClassSectionDto(); 
		List<ClassSectionDto> editClassesSectionData = new ArrayList<ClassSectionDto>();
		
		try {
			Optional<ClassSectionDto> classSectionDtoData = classSectionDaoInterface.findById(editClassSectionDtls.getId());
			
			if(classSectionDtoData.isPresent())
			{
				editClassSectionDto.setId(editClassSectionDtls.getId());
				editClassSectionDto.setClassName(editClassSectionDtls.getClassName());
				editClassSectionDto.setSectionName(editClassSectionDtls.getSectionName());
				editClassSectionDto.setClassTeacher(editClassSectionDtls.getClassTeacher());
				editClassSectionDto.setStrength(editClassSectionDtls.getStrength());
				classSectionDaoInterface.save(editClassSectionDto);
			  
			// Sending response
				responseObjectXML.setStatusCode(HttpStatus.OK.value());
				responseObjectXML.setMessage("Class Section Data Update Successfully");
				responseObjectXML.setData(editClassesSectionData);
			}
		} catch (Exception e) {
			responseObjectXML.setStatusCode(HttpStatus.BAD_REQUEST.value());
			responseObjectXML.setMessage("Error while edit the Class Section Data");
			responseObjectXML.setData(null);
			return new ResponseEntity<ResponseObjectXML<ClassSectionDto>>(responseObjectXML, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<ResponseObjectXML<ClassSectionDto>>(responseObjectXML, HttpStatus.OK);
	
	}

	@Override
	public ResponseEntity<ResponseObjectXML<ClassSectionDto>> deleteClassSectionData(Integer rowId) {

		
		List<ClassSectionDto> classSectionDelData = new ArrayList<ClassSectionDto>();

		try {
			// Delete the Class section Details
			classSectionDaoInterface.deleteById(rowId);

			// Sending response
			responseObjectXML.setStatusCode(HttpStatus.OK.value());
			responseObjectXML.setMessage("Class Section Data delete Successfully");
			responseObjectXML.setData(classSectionDelData);
			return new ResponseEntity<ResponseObjectXML<ClassSectionDto>>(responseObjectXML, HttpStatus.OK);

		} catch (Exception e) {
			responseObjectXML.setStatusCode(HttpStatus.BAD_REQUEST.value());
			responseObjectXML.setMessage("Error while deleting the Class Section data");
			responseObjectXML.setData(null);
			return new ResponseEntity<ResponseObjectXML<ClassSectionDto>>(responseObjectXML, HttpStatus.BAD_REQUEST);
		}
	
	}

	@Override
	public ResponseEntity<ResponseObjectXML<ClassSectionDto>> getAllClassSectionData() {
		
		
		List<ClassSectionDto> classSectionDataList = new ArrayList<ClassSectionDto>();
		
		try {
			List<ClassSectionDto> classSectionDTO = classSectionDaoInterface.findAll();
			
			for (ClassSectionDto classSectionData : classSectionDTO) {
				classSectionDataList.add(classSectionData);
			}
			
			if (classSectionDataList.size() == 0) {
				responseObjectXML.setStatusCode(HttpStatus.NOT_FOUND.value());
				responseObjectXML.setMessage("No records found");
				responseObjectXML.setData(classSectionDataList);
				return new ResponseEntity<ResponseObjectXML<ClassSectionDto>>(responseObjectXML, HttpStatus.OK);
			}
			else
			{
				responseObjectXML.setStatusCode(HttpStatus.OK.value());
				responseObjectXML.setMessage("Data Fetch Successfully");
				responseObjectXML.setData(classSectionDataList);
				return new ResponseEntity<ResponseObjectXML<ClassSectionDto>>(responseObjectXML, HttpStatus.OK);
			}
		} catch (Exception e) {
			responseObjectXML.setStatusCode(HttpStatus.BAD_REQUEST.value());
			responseObjectXML.setMessage("Error while getting the Class Section Data");
			responseObjectXML.setData(null);
			return new ResponseEntity<ResponseObjectXML<ClassSectionDto>>(responseObjectXML,HttpStatus.BAD_REQUEST);
		}
	}
}
