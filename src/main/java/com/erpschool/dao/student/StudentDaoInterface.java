package com.erpschool.dao.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.erpschool.dto.student.StudentDTO;

@Repository
@Transactional
public interface StudentDaoInterface extends JpaRepository<StudentDTO, Integer>{

   // JPQL Query	
   /*
   @Modifying	
   @Query("DELETE from studentinfo std where std.admissionNo=:rowId")	   
   public void deleteStudentByAdmissionNo(String rowId); */
	
   // Native Query
    @Modifying	
	@Query(value = "DELETE from studentinfo std where std.admissionNo=:rowId",nativeQuery = true)	   
	public void deleteStudentByAdmissionNo(String rowId);
}


