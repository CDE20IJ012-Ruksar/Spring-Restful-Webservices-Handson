package com.cognizant.springlearn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.springlearn.model.Employee;
import com.cognizant.springlearn.service.EmployeeService;

@RestController

public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;
	@GetMapping("/employees")
	public List<Employee> getAllEmployees(){
		//log.info("start");
		return employeeService.getAllEmployees() ;
	}
	@GetMapping("/departments")
	public List<Employee> getAllDepartments(){
		//log.info("start");
		return employeeService.getAllDepartments() ;
	}
}
