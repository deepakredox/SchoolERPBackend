package com.erpschool.dao.classes;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.erpschool.dto.classes.ClassesDto;

@Repository
public interface ClassesDaoInterface extends JpaRepository<ClassesDto, Integer> {

}
