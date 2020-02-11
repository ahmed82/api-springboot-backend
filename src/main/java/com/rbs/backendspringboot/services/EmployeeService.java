package com.rbs.backendspringboot.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.rbs.backendspringboot.model.Employee;

@Service
public class EmployeeService {
	
	
	private List<Employee> employees = new ArrayList <> ( 
			Arrays.asList(
		new Employee(5,"Ahmed","ALSALIH","Mooresvile","123456789"),
		new Employee(1,"Mae","Forbes","Charlotte","123456789"),
		new Employee(2,"Sean","Fallmann","somwhere","123456789"),
		new Employee(3,"Aaron","Broom","Concord","123456789"),
		new Employee(4,"Brian","Lindner","Mooresvile","123456789")
		
			));
	
	public List<Employee> getAllEmployees(){
		 return this.employees;
		}
		

}
