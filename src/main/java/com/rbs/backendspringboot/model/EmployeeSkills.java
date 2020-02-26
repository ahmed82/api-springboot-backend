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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + empid;
		result = prime * result + id;
		result = prime * result + ((skill == null) ? 0 : skill.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EmployeeSkills other = (EmployeeSkills) obj;
		if (empid != other.empid)
			return false;
		if (id != other.id)
			return false;
		if (skill == null) {
			if (other.skill != null)
				return false;
		} else if (!skill.equals(other.skill))
			return false;
		return true;
	}

}
