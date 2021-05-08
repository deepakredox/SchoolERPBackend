package com.erpschool.serviceImpl.student;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.erpschool.apiresponse.ResponseObjectXML;
import com.erpschool.dao.student.StudentDaoInterfacess;
import com.erpschool.dto.student.StudentDTO;
import com.erpschool.model.student.StudentDtls;
import com.erpschool.serviceInterface.student.StudentServicesInterface;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

@Service
public class StudentServicesImpl implements StudentServicesInterface {

	@Autowired
	private StudentDaoInterfacess studentDaoInterface;

	@Autowired
	ServletContext context;

	ResponseObjectXML<StudentDTO> responseObjectXML = new ResponseObjectXML<StudentDTO>();

	@Override
	public ResponseEntity<ResponseObjectXML<StudentDTO>> addStudent(StudentDtls studDTls)
			throws JsonMappingException, JsonProcessingException {

		List<StudentDTO> addStudentData = new ArrayList<StudentDTO>();

		try {
			String admissionYear = studDTls.getAdmissionDate().substring(2, 4);

			StudentDTO studentDTO = new StudentDTO();
			studentDTO.setAdmissionDate(studDTls.getAdmissionDate().substring(0, 10));
			studentDTO.setStudentDOB(studDTls.getStudentDOB().substring(0, 10));
			BeanUtils.copyProperties(studDTls, studentDTO);
			studentDaoInterface.save(studentDTO);

			studentDTO.setAdmissionNo(String.format(admissionYear + "%04d", studentDTO.getStudId()));
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

	@Override
	public ResponseEntity<ResponseObjectXML<StudentDTO>> getAllStudents() {

		List<StudentDTO> studentDataList = new ArrayList<StudentDTO>();

		try {
			List<StudentDTO> studentsDTO = studentDaoInterface.findAll();

			for (StudentDTO studentData : studentsDTO) {
				studentDataList.add(studentData);
			}

			System.out.println("Size" + studentDataList.size());

			if (studentDataList.size() == 0) {
				System.out.println("Size1" + studentDataList.size());
				responseObjectXML.setStatusCode(HttpStatus.NOT_FOUND.value());
				responseObjectXML.setMessage("No records found");
				responseObjectXML.setData(studentDataList);
				return new ResponseEntity<ResponseObjectXML<StudentDTO>>(responseObjectXML, HttpStatus.OK);
			} else {
				// Get All Student Images
				getAllStudentImage(studentDataList);

				responseObjectXML.setStatusCode(HttpStatus.OK.value());
				responseObjectXML.setMessage("Data Fetch Successfully");
				responseObjectXML.setData(studentDataList);
				return new ResponseEntity<ResponseObjectXML<StudentDTO>>(responseObjectXML, HttpStatus.OK);
			}
		} catch (Exception e) {
			responseObjectXML.setStatusCode(HttpStatus.BAD_REQUEST.value());
			responseObjectXML.setMessage("Error while getting the data");
			responseObjectXML.setData(null);
			return new ResponseEntity<ResponseObjectXML<StudentDTO>>(responseObjectXML, HttpStatus.BAD_REQUEST);
		}

	}

	// Get All Student Images from database...
	private void getAllStudentImage(List<StudentDTO> studentDataList) {

		for (StudentDTO studentsData : studentDataList) {
			String filesPath = context.getRealPath("/studentImage");
			File fileFolder = new File(filesPath);
			if (fileFolder != null) {
				for (final File file : fileFolder.listFiles()) {
					if (!file.isDirectory()) {
						if (studentsData.getUploadImg().equals(file.getName())) {
							String encodeBase64 = null;
							try {
								FileInputStream fileInputStream = new FileInputStream(file);
								byte[] bytes = new byte[(int) file.length()];
								fileInputStream.read(bytes);
								encodeBase64 = Base64.getEncoder().encodeToString(bytes);
								studentsData.setUploadImg(encodeBase64);
								fileInputStream.close();
							} catch (Exception e) {
								// TODO: handle exception
							}
						}
					}
				}
			}
		}

	}

	@Override
	public ResponseEntity<ResponseObjectXML<StudentDTO>> deleteStudentData(String rowId) {
		
		System.out.println("RowID "+rowId);
		List<StudentDTO> studentDelData = new ArrayList<StudentDTO>();

		try {
			// Delete the Student Details
			studentDaoInterface.deleteStudentByAdmissionNo(rowId);

			// Sending response
			responseObjectXML.setStatusCode(HttpStatus.OK.value());
			responseObjectXML.setMessage("Student Data Delete Successfully");
			responseObjectXML.setData(studentDelData);
			return new ResponseEntity<ResponseObjectXML<StudentDTO>>(responseObjectXML, HttpStatus.OK);

		} catch (Exception e) {
			System.out.println(e);
			responseObjectXML.setStatusCode(HttpStatus.BAD_REQUEST.value());
			responseObjectXML.setMessage("Error while deleting the Class data");
			responseObjectXML.setData(null);
			return new ResponseEntity<ResponseObjectXML<StudentDTO>>(responseObjectXML, HttpStatus.BAD_REQUEST);
		}
	}
}
