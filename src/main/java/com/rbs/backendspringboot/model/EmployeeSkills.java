package com.rbs.backendspringboot.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class EmployeeSkills {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int empid;
	private String skill;
	

	
	public EmployeeSkills(int empid, String skill) {
		super();
		this.empid = empid;
		this.skill = skill;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getEmpid() {
		return empid;
	}
	public void setEmpid(int empid) {
		this.empid = empid;
	}
	public String getSkill() {
		return skill;
	}
	public void setSkill(String skill) {
		this.skill = skill;
	}
	
	
	@Override
	public String toString() {
		return "EmployeeSkills {id=" 
									+ id
									+ ", empid=" 
									+ empid
									+ ", skill=" 
									+ skill 
									+ "}";
	}
	

}
