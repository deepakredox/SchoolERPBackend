package com.erpschool.dao.professor;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import com.erpschool.model.professor.ProfessorDtls;
import com.erpschool.repository.professor.ProfessorRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Transactional
public class ProfessorDaoImpl implements ProfessorDaoInterface {

    @Autowired
    private ProfessorRepositoryInterface professorRepoInterface;

    @Override
    public Integer saveProfData(ProfessorDtls profDtls) {
        Integer saveValue =0;
     try{
          saveValue = professorRepoInterface.addProfessorDtls(profDtls);  
          
     } catch(Exception e) {
         e.getLocalizedMessage();
         e.printStackTrace();
     }
            return saveValue;
    }

    @Override
    public List<Object[]> getAllProfessor() {
            return professorRepoInterface.getAllProfessor();
    }

    @Override
    public Integer editProfessorData(ProfessorDtls professorDtls) {
        // TODO Auto-generated method stub
        return professorRepoInterface.editProfDetails(professorDtls);
    }
}
