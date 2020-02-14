package com.rbs.backendspringboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.rbs.backendspringboot.model.Employee;
import com.rbs.backendspringboot.services.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService employeeservice;

	@GetMapping("/hello")
	public String hello() {
		return "Hello web team";
	}
	
	
	@GetMapping("/employees")
	public List<Employee> getAllEmployee() {
		return employeeservice.getAllEmployees();
	}
	

	@GetMapping("/employees/{id}")
	public Employee getEmployeeById(@PathVariable int id) {
		return employeeservice.getEmployeeById(id);
	}

	@GetMapping(value="/employees/" )
	public ResponseEntity<Employee> getEmployeeById2(@RequestParam("id") int id) {
		
		Employee e = employeeservice.getEmployeeById(id);
		if (e != null ){
			return new ResponseEntity<Employee>(e, HttpStatus.OK);
		}else
		return new ResponseEntity("Not found",HttpStatus.NOT_FOUND);
		
	}
	

	@PostMapping("/employees")
	public Employee AddEmployee(@RequestBody Employee emp){
		return employeeservice.upsertEmployee(emp);
	}
	

	@PatchMapping("/employees/{id}")
	public Employee updateEmployee(@RequestBody Employee emp, @PathVariable int id) {
		emp.setId(id);
		return employeeservice.upsertEmployee(emp);
	}	

	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/employees")
	public @ResponseBody void deleteEmployees(@RequestBody List<Employee> emps) {
		employeeservice.deleteEmployee(emps);
	}
}
