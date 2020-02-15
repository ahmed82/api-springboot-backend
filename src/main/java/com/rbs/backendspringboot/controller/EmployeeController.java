package com.rbs.backendspringboot.controller;

import java.util.List;
import java.util.Optional;

import javax.xml.ws.spi.http.HttpHandler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add("Ahmed-key", "RBS-Value-1");
		httpHeaders.add("Sean-key", "RBS-Value-2");
		httpHeaders.add("Brian-key", "RBS-Value-3");
		if (e != null ){
			return new ResponseEntity<Employee>(e,httpHeaders, HttpStatus.OK);
		}else
		return new ResponseEntity("Not found", httpHeaders, HttpStatus.NOT_FOUND);
		
	}
	

	@PostMapping("/employees")
	public ResponseEntity<Boolean> AddEmployee(@RequestBody Employee emp){
		employeeservice.addemployee(emp);
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add(
						"location",
						ServletUriComponentsBuilder.fromCurrentRequest()
						.path("/{id}")
						.buildAndExpand(emp.getId()).toUri()
						.toString());
		
		return new ResponseEntity <Boolean>(true,httpHeaders,HttpStatus.CREATED);
	}

}
