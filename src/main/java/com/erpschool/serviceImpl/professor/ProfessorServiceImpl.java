package com.erpschool.serviceImpl.professor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erpschool.dao.professor.ProfessorDaoInterface;
import com.erpschool.dto.professor.AddProfessorDTO;
import com.erpschool.model.professor.AddProfessorDtls;
import com.erpschool.serviceInterface.professor.ProfessorServiceInterface;

@Service
public class ProfessorServiceImpl implements ProfessorServiceInterface {

	@Autowired
	private  ProfessorDaoInterface addProfessorDaoInterface;
	
	@Override
	public void addNewProfessor(AddProfessorDtls addProfessorDtls) {
	
		AddProfessorDTO addProfessorDTO = new AddProfessorDTO();
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
		
		addProfessorDaoInterface.save(addProfessorDTO);
	}
}
