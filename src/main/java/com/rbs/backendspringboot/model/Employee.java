package com.rbs.backendspringboot.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity(name="Employee")
public class Employee {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="empid")
	private int empid;
	
	@Column(name="f_name")
	private String firstname;
	
	private String lastname;
	private String address;
	private String phone;
	
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "empid", referencedColumnName = "id")
	private EmployeeSelary employeeSelary;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "empid", referencedColumnName = "empid")
	private List<EmployeeSkills> skills;
	
	
	public Employee() {
		super();
	}

	public Employee(String firstname, String lastname, String address, String phone) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.address = address;
		this.phone = phone;
	}
	
	

	public Employee( String firstname, String lastname, String address, String phone,
			EmployeeSelary employeeSelary) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.address = address;
		this.phone = phone;
		this.employeeSelary = employeeSelary;
	}
	

	public Employee( String firstname, String lastname, String address, String phone,
			EmployeeSelary employeeSelary, List<EmployeeSkills> skills) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.address = address;
		this.phone = phone;
		this.employeeSelary = employeeSelary;
		this.skills = skills;
	}

	public List<EmployeeSkills> getSkills() {
		return skills;
	}

	public void setSkills(List<EmployeeSkills> skills) {
		this.skills = skills;
	}

	public int getEmpid() {
		return empid;
	}

	public void setEmpid(int empid) {
		this.empid = empid;
	}

	public EmployeeSelary getEmployeeSelary() {
		return employeeSelary;
	}

	public void setEmployeeSelary(EmployeeSelary employeeSelary) {
		this.employeeSelary = employeeSelary;
	}

	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
	
}
