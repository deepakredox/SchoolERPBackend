package com.erpschool.serviceImpl.professor;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.erpschool.dao.professor.ProfessorDaoInterface;
import com.erpschool.dto.professor.ProfessorDTO;
import com.erpschool.model.professor.ProfessorDtls;
import com.erpschool.serviceInterface.professor.ProfessorServiceInterface;

@Service
public class ProfessorServiceImpl implements ProfessorServiceInterface {

	@Autowired
	private  ProfessorDaoInterface professorDaoInterface;
	
	@Override
	public void addNewProfessor(ProfessorDtls addProfessorDtls) {
	
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
		
		professorDaoInterface.save(addProfessorDTO);
	}

	@Override
	public void editProfessor(ProfessorDtls editProfessorDtls) {
		
		ProfessorDTO editProfessorDTO = new ProfessorDTO();
		
		Optional<ProfessorDTO> editProfessorDTO1 = professorDaoInterface.findById(editProfessorDtls.getId());
		
		if(editProfessorDTO1.isPresent())
		{
		  System.out.println(editProfessorDtls.getId());
		  editProfessorDTO.setId(editProfessorDtls.getId()); 
		  
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
		}
		else
		{
			System.out.println("Value is not present");	
			addNewProfessor(editProfessorDtls);
		}
	}

	@Override
	public void deleteProfessor(ProfessorDtls delProfessorDtls) {
		
		professorDaoInterface.deleteById(delProfessorDtls.getId());
	}

	@Override
	public Iterable<ProfessorDTO> getAllProfessor() {
		
		Iterable<ProfessorDTO> professorDTO = professorDaoInterface.findAll();
		return professorDTO;
	}
}
