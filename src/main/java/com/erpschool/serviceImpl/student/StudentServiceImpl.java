package com.erpschool.serviceImpl.student;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.erpschool.apiresponse.ResponseObjectXML;
import com.erpschool.dao.student.StudentDaoInterface;
import com.erpschool.dto.student.StudentDTO;
import com.erpschool.model.student.StudentDtls;
import com.erpschool.serviceInterface.student.StudentServiceInterface;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

@Service
public class StudentServiceImpl implements StudentServiceInterface {
	
	@Autowired
	private StudentDaoInterface studentDaoInterface;
	
	ResponseObjectXML<StudentDTO> responseObjectXML = new ResponseObjectXML<StudentDTO>();

	@Override
	public ResponseEntity<ResponseObjectXML<StudentDTO>> addStudent(StudentDtls studDTls) throws JsonMappingException, JsonProcessingException{
		
		List<StudentDTO> addStudentData = new ArrayList<StudentDTO>();
		
		try {
			String admissionYear = studDTls.getAdmissionDate().substring(2,4);
			
			StudentDTO studentDTO = new StudentDTO();
			studentDTO.setAdmissionDate(studDTls.getAdmissionDate().substring(0, 10));
			studentDTO.setStudentDOB(studDTls.getStudentDOB().substring(0, 10));
			BeanUtils.copyProperties(studDTls, studentDTO);
			studentDaoInterface.save(studentDTO);
			
			
			studentDTO.setAdmissionNo(String.format(admissionYear+"%04d",studentDTO.getStudId()));
			studentDaoInterface.save(studentDTO);
			
			responseObjectXML.setStatusCode(HttpStatus.OK.value());
			responseObjectXML.setMessage("New Student has been Added");
			responseObjectXML.setData(addStudentData);
			return new ResponseEntity<ResponseObjectXML<StudentDTO>>(responseObjectXML, HttpStatus.OK);
		} catch (BeansException e) {
			// TODO Auto-generated catch block
			responseObjectXML.setStatusCode(HttpStatus.BAD_REQUEST.value());
			responseObjectXML.setMessage("Errro in saving student data");
			responseObjectXML.setData(null);
		    return new ResponseEntity<ResponseObjectXML<StudentDTO>>(responseObjectXML, HttpStatus.BAD_REQUEST);
		}
	}
}
