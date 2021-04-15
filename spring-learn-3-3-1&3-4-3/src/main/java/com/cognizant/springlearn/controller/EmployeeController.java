package com.cognizant.springlearn.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.springlearn.dao.EmployeeNotFoundException;
import com.cognizant.springlearn.model.Department;
import com.cognizant.springlearn.model.Employee;
import com.cognizant.springlearn.service.DepartmentService;
import com.cognizant.springlearn.service.EmployeeService;

@RestController

public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);
	
	@GetMapping("/employees")
	public List<Employee> getAllEmployees(){
		//log.info("start");
		return employeeService.getAllEmployees() ;
	}
	
	@PutMapping("/update")
	public void updateEmployee(@RequestBody @Valid Employee employee) throws EmployeeNotFoundException{
		LOGGER.info("Start updateEmployees");
		employeeService.updateEmployee(employee);
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteEmployee(@PathVariable("id") int id) throws EmployeeNotFoundException{
		LOGGER.info("Start deleteEmployees");
		employeeService.deleteEmployee(id);
	}
	
}
