package com.erpschool.controller.professor;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.erpschool.apiresponse.ResponseObjectXML;
import com.erpschool.dto.professor.ProfessorDTO;
import com.erpschool.model.professor.ProfessorDtls;
import com.erpschool.serviceInterface.professor.ProfessorServiceInterface;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ProfessorController {

	@Autowired
	private ProfessorServiceInterface professorServiceInterface;

	ResponseObjectXML<ProfessorDTO> responseObjectXML = new ResponseObjectXML<ProfessorDTO>();

	@PostMapping("/addProfessor")
	public ResponseEntity<ResponseObjectXML<ProfessorDTO>> addnewProfessor(@RequestBody ProfessorDtls addProfessorDtls) {
		
		List<ProfessorDTO> professorData = new ArrayList<ProfessorDTO>();
		
		try {
			// Professor Added to database
			professorServiceInterface.addNewProfessor(addProfessorDtls);
			
			// Sending response
			responseObjectXML.setStatusCode(HttpStatus.OK.value());
			responseObjectXML.setMessage("Record Added Successfully!!!!!!");
			responseObjectXML.setData(professorData);
			return new ResponseEntity<ResponseObjectXML<ProfessorDTO>>(responseObjectXML, HttpStatus.OK);
		} catch (Exception e) {
			responseObjectXML.setStatusCode(HttpStatus.BAD_REQUEST.value());
			responseObjectXML.setMessage("Record is not added");
			responseObjectXML.setData(null);
			return new ResponseEntity<ResponseObjectXML<ProfessorDTO>>(responseObjectXML,HttpStatus.BAD_REQUEST);
		}
	}

	@PostMapping("/editProfessor")
	public ResponseEntity<ResponseObjectXML<ProfessorDTO>> editProfessor(@RequestBody ProfessorDtls editProfessorDtls) {
		
		List<ProfessorDTO> professorEditData = new ArrayList<ProfessorDTO>();
		try {
			// Updating the Professor Details
			professorServiceInterface.editProfessor(editProfessorDtls);
			
			// Sending response
			responseObjectXML.setStatusCode(HttpStatus.OK.value());
			responseObjectXML.setMessage("Data Update Successfully");
			responseObjectXML.setData(professorEditData);
			return new ResponseEntity<ResponseObjectXML<ProfessorDTO>>(responseObjectXML,HttpStatus.OK);
			
		} catch (Exception e) {
			responseObjectXML.setStatusCode(HttpStatus.BAD_REQUEST.value());
			responseObjectXML.setMessage("Error while edit the Professor Data");
			responseObjectXML.setData(null);
			return new ResponseEntity<ResponseObjectXML<ProfessorDTO>>(responseObjectXML,HttpStatus.BAD_REQUEST);
		}
	}

	@PostMapping("/deleteProfessor")
	public ResponseEntity<ResponseObjectXML<ProfessorDTO>> deleteProfessor(@RequestBody ProfessorDtls delProfessorDtls) {
		
		List<ProfessorDTO> professorDelData = new ArrayList<ProfessorDTO>();
		try {
			// Delete the Professor Details
			professorServiceInterface.deleteProfessor(delProfessorDtls);
			
			// Sending response
			  responseObjectXML.setStatusCode(HttpStatus.OK.value());
			  responseObjectXML.setMessage("Data delete Successfully");
			  responseObjectXML.setData(professorDelData);
			  return new ResponseEntity<ResponseObjectXML<ProfessorDTO>>(responseObjectXML,HttpStatus.OK);
			  
		} catch (Exception e) {
			responseObjectXML.setStatusCode(HttpStatus.BAD_REQUEST.value());
			responseObjectXML.setMessage("Error while deleting the data");
			responseObjectXML.setData(null);
			return new ResponseEntity<ResponseObjectXML<ProfessorDTO>>(responseObjectXML,HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/getAllProfessor")
	public ResponseEntity<ResponseObjectXML<ProfessorDTO>> getAllProfessor() {

		List<ProfessorDTO> professorDataList = new ArrayList<ProfessorDTO>();

		try {
			Iterable<ProfessorDTO> professorDTO = professorServiceInterface.getAllProfessor();

			for (ProfessorDTO professorData : professorDTO) {
				professorDataList.add(professorData);
			}
			
			System.out.println("Size"+professorDataList.size());
			
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
			responseObjectXML.setMessage("Error while deleting the data");
			responseObjectXML.setData(null);
			return new ResponseEntity<ResponseObjectXML<ProfessorDTO>>(responseObjectXML,HttpStatus.BAD_REQUEST);
		}
	}
}
