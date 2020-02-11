package com.rbs.backendspringboot.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

import com.rbs.backendspringboot.model.Employee;

@Component
public class EmployeeService {
	
	
	private List<Employee> employees = new ArrayList <> ( 
			Arrays.asList(
		new Employee(1,"Mae","Forbes","Charlotte","123456789"),
		new Employee(2,"Sean","Fallmann","Charlotte","123456789"),
		new Employee(3,"Aaron","Broom","Charlotte","123456789"),
		new Employee(4,"Brian","Lindner","Charlotte","123456789"),
		new Employee(5,"Ahmed","ALSALIH","Charlotte","123456789")
			));
	
	public List<Employee> getAllEmployees(){
		 return this.employees;
		}
		

}
