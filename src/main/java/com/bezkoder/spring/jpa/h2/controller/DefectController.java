package com.bezkoder.spring.jpa.h2.controller;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bezkoder.spring.jpa.h2.model.Defect;
import com.bezkoder.spring.jpa.h2.repository.DefectRepository;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class DefectController {

	@Autowired
	DefectRepository defectRepository;

	@GetMapping("/defects")
	public ResponseEntity<List<Defect>> getAllDefects(

			@RequestParam(value = "sysplex_name", required = false) String sysplex_name) {
		try {
			List<Defect> defects = new ArrayList<Defect>();

			if (sysplex_name == null)
				defectRepository.findAll().forEach(defects::add);
			else
				defectRepository.findBySysplexnameContaining(sysplex_name).forEach(defects::add);
			System.out.println(defects.size());
			if (defects.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(defects, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/defects/{id}")
	public ResponseEntity<Defect> getDefectById(@PathVariable("id") String id) {
		Optional<Defect> defectData = defectRepository.findById(id);

		if (defectData.isPresent()) {
			return new ResponseEntity<>(defectData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/defects")
	public ResponseEntity<Defect> createDefect(@RequestBody Defect defect) {
		try {
			Date today = new Date();
			java.util.Date _today = today;
			Timestamp  createdon = new Timestamp(_today.getTime());
			Defect _defect = defectRepository
					.save(new Defect(createdon.toString(), defect.getSysplexname(), defect.getLpar_name(), defect.getTest_env_name(),
							defect.getDbdetails(), defect.getJobdetails(), defect.getStatus(), defect.getWork_group(),
							defect.getCreatedbyid(), defect.getAssignedtoid(), defect.getValidatedbyid(),
							defect.getDescription(), defect.getAction(), defect.getUpdatedbyid()));
			return new ResponseEntity<>(_defect, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/defects/{id}")
	public ResponseEntity<Defect> updateDefect(@PathVariable("id") String id, @RequestBody Defect defect) {
		Optional<Defect> defectData = defectRepository.findById(id);

		if (defectData.isPresent()) {
			Defect _defect = defectData.get();
			_defect.setId(id);
			_defect.setSysplexname(defect.getSysplexname());
			_defect.setLpar_name(defect.getLpar_name());
			_defect.setTest_env_name(defect.getTest_env_name());
			_defect.setDbdetails(defect.getDbdetails());
			_defect.setJobdetails(defect.getJobdetails());
			_defect.setStatus(defect.getStatus());
			_defect.setWork_group(defect.getWork_group());
			_defect.setCreatedbyid(defect.getCreatedbyid());
			_defect.setAssignedtoid(defect.getAssignedtoid());
			_defect.setValidatedbyid(defect.getValidatedbyid());
			_defect.setDescription(defect.getDescription());
			_defect.setAction(defect.getAction());
			_defect.setUpdatedbyid(defect.getUpdatedbyid());
			return new ResponseEntity<>(defectRepository.save(_defect), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/defects/{id}")
	public ResponseEntity<HttpStatus> deleteDefect(@PathVariable("id") String id) {
		try {
			defectRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/defects")
	public ResponseEntity<HttpStatus> deleteAllDefects() {
		try {
			defectRepository.deleteAll();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
}
