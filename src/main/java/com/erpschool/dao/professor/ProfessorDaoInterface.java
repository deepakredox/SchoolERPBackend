package com.erpschool.dao.professor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

import javax.transaction.Transactional;

import com.erpschool.dto.professor.ProfessorDTO;

@Repository
public interface ProfessorDaoInterface extends JpaRepository<ProfessorDTO,Integer> {
    
    @Transactional
    @Modifying
    // @Query("select pi from professor_info pi") JPQL
    @Query(value ="select * from professor_info pi", nativeQuery = true)  // native query
    public List<ProfessorDTO> getProfesstor();
}
