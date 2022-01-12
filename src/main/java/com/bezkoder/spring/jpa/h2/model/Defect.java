package com.bezkoder.spring.jpa.h2.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "defect")
public class Defect {

	@Id
	@Column(name = "id")
	private String id;
	
	
	@Column(name = "sysplex_name")
	private String sysplexname;
	
	
	@Column(name = "lpar_name")
	private String lpar_name;
	
	
	@Column(name = "test_env_name")
	private String test_env_name;
	
	@Column(name = "dbdetails")
	
	private String dbdetails;
	
	@Column(name = "jobdetails")
	
	private String jobdetails;
	
	@Column(name = "status")
	private String status;
	
	@Column(name = "work_group")
	private String work_group;
	
	@Column(name = "createdbyid")
	private String createdbyid;
	
	@Column(name = "assignedtoid")
	private String assignedtoid;
	
	@Column(name = "validatedbyid")
	private String validatedbyid;	

	@Column(name = "description")
	private String description;

	@Column(name = "action")
	private String action;
	
	
	
	@Column(name = "updatedbyid")
	private String updatedbyid;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSysplexname() {
		return sysplexname;
	}

	public void setSysplexname(String sysplexname) {
		this.sysplexname = sysplexname;
	}

	public String getLpar_name() {
		return lpar_name;
	}

	public void setLpar_name(String lpar_name) {
		this.lpar_name = lpar_name;
	}

	public String getTest_env_name() {
		return test_env_name;
	}

	public void setTest_env_name(String test_env_name) {
		this.test_env_name = test_env_name;
	}

	public String getDbdetails() {
		return dbdetails;
	}

	public void setDbdetails(String dbdetails) {
		this.dbdetails = dbdetails;
	}

	public String getJobdetails() {
		return jobdetails;
	}

	public void setJobdetails(String jobdetails) {
		this.jobdetails = jobdetails;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getWork_group() {
		return work_group;
	}

	public void setWork_group(String work_group) {
		this.work_group = work_group;
	}

	public String getCreatedbyid() {
		return createdbyid;
	}

	public void setCreatedbyid(String createdbyid) {
		this.createdbyid = createdbyid;
	}

	public String getAssignedtoid() {
		return assignedtoid;
	}

	public void setAssignedtoid(String assignedtoid) {
		this.assignedtoid = assignedtoid;
	}

	public String getValidatedbyid() {
		return validatedbyid;
	}

	public void setValidatedbyid(String validatedbyid) {
		this.validatedbyid = validatedbyid;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getUpdatedbyid() {
		return updatedbyid;
	}

	public void setUpdatedbyid(String updatedbyid) {
		this.updatedbyid = updatedbyid;
	}

	public Defect() {
		super();
	}

	public Defect(String id, String sysplexname, String lpar_name, String test_env_name, String dbdetails,
			String jobdetails, String status, String work_group, String createdbyid, String assignedtoid,
			String validatedbyid, String description, String action, String updatedbyid) {
		super();
		
		this.id = id;
		this.sysplexname = sysplexname;
		this.lpar_name = lpar_name;
		this.test_env_name = test_env_name;
		this.dbdetails = dbdetails;
		this.jobdetails = jobdetails;
		this.status = status;
		this.work_group = work_group;
		this.createdbyid = createdbyid;
		this.assignedtoid = assignedtoid;
		this.validatedbyid = validatedbyid;
		this.description = description;
		this.action = action;		
		this.updatedbyid = updatedbyid;
	}

	

}
