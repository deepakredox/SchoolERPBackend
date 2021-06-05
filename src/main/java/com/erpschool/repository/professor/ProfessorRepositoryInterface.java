package com.erpschool.repository.professor;

import java.util.List;

import com.erpschool.model.professor.ProfessorDtls;


public interface ProfessorRepositoryInterface {
    
    Integer addProfessorDtls(ProfessorDtls profDtls);
    List<Object[]> getAllProfessor();
    Integer editProfDetails(ProfessorDtls professorDtls , Integer professorId);
}
