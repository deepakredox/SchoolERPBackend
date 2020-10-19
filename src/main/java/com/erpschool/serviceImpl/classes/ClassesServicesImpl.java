package com.erpschool.serviceImpl.classes;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.erpschool.apiresponse.ResponseObjectXML;
import com.erpschool.dao.classes.ClassesDaoInterface;
import com.erpschool.dto.classes.ClassesDto;
import com.erpschool.model.classes.ClassDtls;
import com.erpschool.serviceInterface.classes.ClassesServiceInterface;

@Service
public class ClassesServicesImpl implements ClassesServiceInterface {

	@Autowired
	private ClassesDaoInterface classesDaoInterface;

	ResponseObjectXML<ClassesDto> responseObjectXML = new ResponseObjectXML<ClassesDto>();

	@Override
	public ResponseEntity<ResponseObjectXML<ClassesDto>> addNewClassData(ClassDtls classDtls) {

		List<ClassesDto> addClassesData = new ArrayList<ClassesDto>();

		try {
			ClassesDto classesDto = new ClassesDto();
			classesDto.setClassName(classDtls.getClassName());
			classesDto.setAbbreviation(classDtls.getAbbreviation());
			classesDto.setPriority(classDtls.getPriority());
			classesDaoInterface.save(classesDto);

			responseObjectXML.setStatusCode(HttpStatus.OK.value());
			responseObjectXML.setMessage("New Class has been Added");
			responseObjectXML.setData(addClassesData);
			return new ResponseEntity<ResponseObjectXML<ClassesDto>>(responseObjectXML, HttpStatus.OK);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			responseObjectXML.setStatusCode(HttpStatus.BAD_REQUEST.value());
			responseObjectXML.setMessage("Errro in saving data");
			responseObjectXML.setData(null);
			return new ResponseEntity<ResponseObjectXML<ClassesDto>>(responseObjectXML, HttpStatus.BAD_REQUEST);
		}
	}

	@Override
	public ResponseEntity<ResponseObjectXML<ClassesDto>> editCLassData(ClassDtls editclassDtls) {
		
		ClassesDto editclassesdto = new ClassesDto(); 
		List<ClassesDto> editClassesData = new ArrayList<ClassesDto>();
		
		try {
			Optional<ClassesDto> classesDtoData = classesDaoInterface.findById(editclassDtls.getId());
			
			if(classesDtoData.isPresent())
			{
			  System.out.println("Classes Data value is present");	
			  editclassesdto.setId(editclassDtls.getId());
			  editclassesdto.setClassName(editclassDtls.getClassName());
			  editclassesdto.setAbbreviation(editclassDtls.getAbbreviation());
			  editclassesdto.setPriority(editclassDtls.getPriority());
			  classesDaoInterface.save(editclassesdto);
			  
			// Sending response
				responseObjectXML.setStatusCode(HttpStatus.OK.value());
				responseObjectXML.setMessage("Class Data Update Successfully");
				responseObjectXML.setData(editClassesData);
			}
			else
			{
			  System.out.println("Class Data not found");
			  addNewClassData(editclassDtls);
			}
		} catch (Exception e) {
			responseObjectXML.setStatusCode(HttpStatus.BAD_REQUEST.value());
			responseObjectXML.setMessage("Error while edit the Professor Data");
			responseObjectXML.setData(null);
			return new ResponseEntity<ResponseObjectXML<ClassesDto>>(responseObjectXML, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<ResponseObjectXML<ClassesDto>>(responseObjectXML, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<ResponseObjectXML<ClassesDto>> deleteClassData(ClassDtls deleteclassDtls) {
		
		List<ClassesDto> classesDelData = new ArrayList<ClassesDto>();

		try {
			// Delete the Professor Details
			classesDaoInterface.deleteById(deleteclassDtls.getId());

			// Sending response
			responseObjectXML.setStatusCode(HttpStatus.OK.value());
			responseObjectXML.setMessage("Classes Data delete Successfully");
			responseObjectXML.setData(classesDelData);
			return new ResponseEntity<ResponseObjectXML<ClassesDto>>(responseObjectXML, HttpStatus.OK);

		} catch (Exception e) {
			responseObjectXML.setStatusCode(HttpStatus.BAD_REQUEST.value());
			responseObjectXML.setMessage("Error while deleting the Class data");
			responseObjectXML.setData(null);
			return new ResponseEntity<ResponseObjectXML<ClassesDto>>(responseObjectXML, HttpStatus.BAD_REQUEST);
		}
	}

	@Override
	public ResponseEntity<ResponseObjectXML<ClassesDto>> getAllClasses() {
       
		List<ClassesDto> classesDataList = new ArrayList<ClassesDto>();
		
		
		try {
			List<ClassesDto> classesDTO = classesDaoInterface.findAll();
			
			for (ClassesDto classesData : classesDTO) {
				classesDataList.add(classesData);
			}
			
			System.out.println("Size"+classesDataList.size());
			
			if (classesDataList.size() == 0) {
				responseObjectXML.setStatusCode(HttpStatus.NOT_FOUND.value());
				responseObjectXML.setMessage("No records found");
				responseObjectXML.setData(classesDataList);
				return new ResponseEntity<ResponseObjectXML<ClassesDto>>(responseObjectXML, HttpStatus.NOT_FOUND);
			}
			else
			{
				responseObjectXML.setStatusCode(HttpStatus.OK.value());
				responseObjectXML.setMessage("Data Fetch Successfully");
				responseObjectXML.setData(classesDataList);
				return new ResponseEntity<ResponseObjectXML<ClassesDto>>(responseObjectXML, HttpStatus.OK);
			}
		} catch (Exception e) {
			responseObjectXML.setStatusCode(HttpStatus.BAD_REQUEST.value());
			responseObjectXML.setMessage("Error while getting the data");
			responseObjectXML.setData(null);
			return new ResponseEntity<ResponseObjectXML<ClassesDto>>(responseObjectXML,HttpStatus.BAD_REQUEST);
		}
	}
}


