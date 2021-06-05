package com.erpschool.dao.professor;

import java.util.List;

import com.erpschool.model.professor.ProfessorDtls;


public interface ProfessorDaoInterface {
    
    Integer saveProfData(ProfessorDtls profDtls);
    List<Object[]> getAllProfessor();
    Integer editProfessorData(ProfessorDtls professorDtls);
}
