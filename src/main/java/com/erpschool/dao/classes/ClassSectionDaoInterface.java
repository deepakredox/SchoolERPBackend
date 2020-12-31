package com.erpschool.dao.classes;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.erpschool.dto.classes.ClassSectionDto;

@Repository
public interface ClassSectionDaoInterface extends JpaRepository<ClassSectionDto,Integer> {

}
