package com.bezkoder.spring.jpa.h2.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bezkoder.spring.jpa.h2.model.Defect;

public interface DefectRepository extends JpaRepository<Defect, String> {
	 List<Defect> findBySysplexnameContaining(String sysplex_name);
     Optional<Defect> findById(String id);
     void deleteById(String id);
}
