package com.rbs.backendspringboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rbs.backendspringboot.model.Employee;
import com.rbs.backendspringboot.services.EmployeeService;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeservice;
	
	@GetMapping("/employees")
	public List<Employee> getAllEmployee(){
		return employeeservice.getAllEmployees();
	}

}
