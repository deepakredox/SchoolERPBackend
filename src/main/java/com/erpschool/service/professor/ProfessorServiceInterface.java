package com.erpschool.service.professor;

import java.util.List;

import com.erpschool.model.professor.ProfessorDtls;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

import org.springframework.web.multipart.MultipartFile;

public interface ProfessorServiceInterface {
    
    Boolean addNewProfessor(String profInfo, MultipartFile file) throws JsonMappingException, JsonProcessingException;
    List<ProfessorDtls> getAllProfessor();
    Boolean editProfessor(ProfessorDtls professorDtls);
}
