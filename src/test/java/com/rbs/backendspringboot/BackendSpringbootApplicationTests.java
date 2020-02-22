package com.rbs.backendspringboot;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.rbs.backendspringboot.model.Employee;
import com.rbs.backendspringboot.repository.EmployeeRepository;

@SpringBootTest
class BackendSpringbootApplicationTests {

	@Test
	void contextLoads() {
	}
	 	@Autowired
	    private EmployeeRepository employeeRepository;
	 
	    @Test
	    public void findAllEmployee() {
	        List<Employee> employee = (List<Employee>) employeeRepository.findAll();
	        assertNotNull(employee);
	        assertTrue(!employee.isEmpty());
	    }
	 
	    @Test
	    public void findUserById() {
	        Optional<Employee> employee = employeeRepository.findById(1)  ;
	        assertNotNull(employee);
	    }
	 
	/*
	 * @Test public void createUser() { Employee employee = new
	 * Employee("Tim","Mcluden","Boston","123456789"); Employee savedEmployee =
	 * employeeRepository.save(employee); Employee newEmployee =
	 * employeeRepository.findById(savedEmployee.getId()).orElse(null);
	 * assertNotNull(newEmployee); assertEquals("Tim", newEmployee.getFirstname() );
	 * assertEquals("Mcluden", newEmployee.getLastname()); assertEquals("Boston",
	 * newEmployee.getAddress()); assertEquals("123456789", newEmployee.getPhone());
	 * }
	 */

}
