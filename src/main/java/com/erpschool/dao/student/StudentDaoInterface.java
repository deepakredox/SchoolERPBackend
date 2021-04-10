package com.erpschool.dao.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.erpschool.dto.student.StudentDTO;

@Repository
public interface StudentDaoInterface extends JpaRepository<StudentDTO, Integer> {

}
