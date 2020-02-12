package com.rbs.backendspringboot.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rbs.backendspringboot.model.Employee;
import com.rbs.backendspringboot.services.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService employeeservice;

	@GetMapping("/employees")
	public List<Employee> getAllEmployee() {
		return employeeservice.getAllEmployees();
	}

	@GetMapping("/hello")
	public String hello() {
		return "Hello web team";
	}

	@GetMapping("/employees/{id}")
	public Optional<Employee> getEmployeeById(@PathVariable int id) {
		return employeeservice.getEmployeeById(id);
	}

	@GetMapping("/employees/")
	public Optional<Employee> getEmployeeById2(@RequestParam("record") int id) {
		return employeeservice.getEmployeeById(id);
	}

}
