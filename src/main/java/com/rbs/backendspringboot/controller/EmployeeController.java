package com.rbs.backendspringboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
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
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.rbs.backendspringboot.model.Employee;
import com.rbs.backendspringboot.services.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/hello")
	public String hello() {
		return "Hello web team";
	}
	
	
	@GetMapping("/employees")
	public List<Employee> getAllEmployee() {
		return employeeService.getAllEmployees();
	}
	

	@GetMapping("/employees/{id}")
	public Employee getEmployeeById(@PathVariable int id) {
		return employeeService.getEmployeeById(id);
	}

	@GetMapping(value="/employees/" )
	public ResponseEntity<Employee> getEmployeeById2(@RequestParam("id") int id) {
		
		Employee e = employeeService.getEmployeeById(id);
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add("Ahmed-key", "RBS-Value-1");
		httpHeaders.add("Sean-key", "RBS-Value-2");
		httpHeaders.add("Brian-key", "RBS-Value-3");
		if (e != null ){
			return new ResponseEntity<Employee>(e,httpHeaders, HttpStatus.OK);
		}else
		//return new ResponseEntity("Not found", httpHeaders, HttpStatus.NOT_FOUND);
			throw new NullPointerException("Employee Not found for the given id: "+id);
		
	}
	

	@PostMapping("/employees")
	public ResponseEntity<Boolean> AddEmployee(@RequestBody Employee emp){
		employeeservice.addemployee(emp);

		HttpHeaders httpHeaders = new HttpHeaders();
		/* Http Headers return the new created Employee API url by build the link
		 *  on fly and send it back in the header respond to fetch that particular Employee
		 *  Best practice rather than return the created Employee   */
		httpHeaders.add(
						"location",
						ServletUriComponentsBuilder.fromCurrentRequest()
						.path("/{id}")
						.buildAndExpand(emp.getId()).toUri()
						.toString());
		

		return new ResponseEntity <Boolean>(true,httpHeaders,HttpStatus.CREATED);

	}
	

	@PatchMapping("/employees/{id}")
	public Employee updateEmployee(@RequestBody Employee emp, @PathVariable int id) {
		emp.setId(id);
		return employeeService.upsertEmployee(emp);
	}	

	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/employees")
	public @ResponseBody void deleteEmployees(@RequestBody List<Employee> emps) {
		employeeService.deleteEmployee(emps);

	}
}
