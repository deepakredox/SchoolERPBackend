package com.erpschool.dao.classes;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.erpschool.dto.classes.SectionDto;

@Repository
public interface SectionDaoInterface extends JpaRepository<SectionDto, Integer> {

}
