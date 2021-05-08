package com.erpschool.serviceImpl.professor;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.erpschool.apiresponse.ResponseObjectXML;
import com.erpschool.dao.professor.ProfessorDaoInterface;
import com.erpschool.dto.professor.ProfessorDTO;
import com.erpschool.model.professor.ProfessorDtls;
import com.erpschool.serviceInterface.professor.ProfessorServiceInterface;

@Service
public class ProfessorServiceImpl implements ProfessorServiceInterface {

	@Autowired
	private ProfessorDaoInterface professorDaoInterface;

	ResponseObjectXML<ProfessorDTO> responseObjectXML = new ResponseObjectXML<ProfessorDTO>();

	@Override
	public ResponseEntity<ResponseObjectXML<ProfessorDTO>> addNewProfessorData(ProfessorDtls addProfessorDtls) {

		// Create a ArrayList
		List<ProfessorDTO> professorData = new ArrayList<ProfessorDTO>();

		try {
			// Save Data to Database
			ProfessorDTO addProfessorDTO = new ProfessorDTO();
			addProfessorDTO.setFirstname(addProfessorDtls.getFirstname());
			addProfessorDTO.setLastname(addProfessorDtls.getLastname());
			addProfessorDTO.setGender(addProfessorDtls.getGender());
			addProfessorDTO.setMobile(addProfessorDtls.getMobile());
			addProfessorDTO.setPassword(addProfessorDtls.getPassword());
			addProfessorDTO.setConformPassword(addProfessorDtls.getConformPassword());
			addProfessorDTO.setDesignation(addProfessorDtls.getDesignation());
			addProfessorDTO.setDepartment(addProfessorDtls.getDepartment());
			addProfessorDTO.setAddress(addProfessorDtls.getAddress());
			addProfessorDTO.setEmail(addProfessorDtls.getEmail());
			addProfessorDTO.setDob(addProfessorDtls.getDob());
			addProfessorDTO.setEducation(addProfessorDtls.getEducation());
			addProfessorDTO.setUploadImg(addProfessorDtls.getUploadImg());
			addProfessorDTO = professorDaoInterface.save(addProfessorDTO);

			// Sending response
			responseObjectXML.setStatusCode(HttpStatus.OK.value());
			responseObjectXML.setMessage("Record Added Successfully!!!!!!");
			responseObjectXML.setData(professorData);
			return new ResponseEntity<ResponseObjectXML<ProfessorDTO>>(responseObjectXML, HttpStatus.OK);

		} catch (Exception e) {
			responseObjectXML.setStatusCode(HttpStatus.BAD_REQUEST.value());
			responseObjectXML.setMessage("Record is not added");
			responseObjectXML.setData(null);
			return new ResponseEntity<ResponseObjectXML<ProfessorDTO>>(responseObjectXML, HttpStatus.BAD_REQUEST);
		}
	}

	@Override
	public ResponseEntity<ResponseObjectXML<ProfessorDTO>> editProfessorData(ProfessorDtls editProfessorDtls , Integer professorId) {

		ProfessorDTO editProfessorDTO = new ProfessorDTO();
		List<ProfessorDTO> professorEditData = new ArrayList<ProfessorDTO>();

		try {
			Optional<ProfessorDTO> editProfessorDTO1 = professorDaoInterface.findById(professorId);

			if (editProfessorDTO1.isPresent()) {
				editProfessorDTO.setId(professorId);
				editProfessorDTO.setFirstname(editProfessorDtls.getFirstname());
				editProfessorDTO.setLastname(editProfessorDtls.getLastname());
				editProfessorDTO.setGender(editProfessorDtls.getGender());
				editProfessorDTO.setMobile(editProfessorDtls.getMobile());
				editProfessorDTO.setPassword(editProfessorDtls.getPassword());
				editProfessorDTO.setConformPassword(editProfessorDtls.getConformPassword());
				editProfessorDTO.setDesignation(editProfessorDtls.getDesignation());
				editProfessorDTO.setDepartment(editProfessorDtls.getDepartment());
				editProfessorDTO.setAddress(editProfessorDtls.getAddress());
				editProfessorDTO.setEmail(editProfessorDtls.getEmail());
				editProfessorDTO.setDob(editProfessorDtls.getDob());
				editProfessorDTO.setEducation(editProfessorDtls.getEducation());
				editProfessorDTO.setUploadImg(editProfessorDtls.getUploadImg());
				professorDaoInterface.save(editProfessorDTO);

				// Sending response
				responseObjectXML.setStatusCode(HttpStatus.OK.value());
				responseObjectXML.setMessage("Data Update Successfully");
				responseObjectXML.setData(professorEditData);
			} else {
				System.out.println("Value is not present");
				addNewProfessorData(editProfessorDtls);
			}

		} catch (Exception e) {
			responseObjectXML.setStatusCode(HttpStatus.BAD_REQUEST.value());
			responseObjectXML.setMessage("Error while edit the Professor Data");
			responseObjectXML.setData(null);
			return new ResponseEntity<ResponseObjectXML<ProfessorDTO>>(responseObjectXML, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<ResponseObjectXML<ProfessorDTO>>(responseObjectXML, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<ResponseObjectXML<ProfessorDTO>> deleteProfessorData(Integer professorId) {

		List<ProfessorDTO> professorDelData = new ArrayList<ProfessorDTO>();

		try {
			// Delete the Professor Details
			professorDaoInterface.deleteById(professorId);

			// Sending response
			responseObjectXML.setStatusCode(HttpStatus.OK.value());
			responseObjectXML.setMessage("Data delete Successfully");
			responseObjectXML.setData(professorDelData);
			return new ResponseEntity<ResponseObjectXML<ProfessorDTO>>(responseObjectXML, HttpStatus.OK);

		} catch (Exception e) {
			responseObjectXML.setStatusCode(HttpStatus.BAD_REQUEST.value());
			responseObjectXML.setMessage("Error while deleting the data");
			responseObjectXML.setData(null);
			return new ResponseEntity<ResponseObjectXML<ProfessorDTO>>(responseObjectXML, HttpStatus.BAD_REQUEST);
		}
	}

	@Override
	public ResponseEntity<ResponseObjectXML<ProfessorDTO>> getAllProfessorData() {
		
		List<ProfessorDTO> professorDataList = new ArrayList<ProfessorDTO>();
		
		
		try {
			List<ProfessorDTO> professorDTO = professorDaoInterface.getProfesstor();
			
			for (ProfessorDTO professorData : professorDTO) {
				professorDataList.add(professorData);
			}
			
			System.out.println("Size"+professorDataList.size() + "list" + professorDataList);
			
			if (professorDataList.size() == 0) {
				responseObjectXML.setStatusCode(HttpStatus.NOT_FOUND.value());
				responseObjectXML.setMessage("No records found");
				responseObjectXML.setData(professorDataList);
				return new ResponseEntity<ResponseObjectXML<ProfessorDTO>>(responseObjectXML, HttpStatus.NOT_FOUND);
			}
			else
			{
				responseObjectXML.setStatusCode(HttpStatus.OK.value());
				responseObjectXML.setMessage("Data Fetch Successfully");
				responseObjectXML.setData(professorDataList);
				return new ResponseEntity<ResponseObjectXML<ProfessorDTO>>(responseObjectXML, HttpStatus.OK);
			}
		} catch (Exception e) {
			responseObjectXML.setStatusCode(HttpStatus.BAD_REQUEST.value());
			responseObjectXML.setMessage("Error while getting the data");
			responseObjectXML.setData(null);
			return new ResponseEntity<ResponseObjectXML<ProfessorDTO>>(responseObjectXML,HttpStatus.BAD_REQUEST);
		}
	}
}
