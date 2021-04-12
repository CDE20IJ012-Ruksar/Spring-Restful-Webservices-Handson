package com.cognizant.springlearn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.springlearn.dao.EmployeeDao;
import com.cognizant.springlearn.model.Employee;

@Service

public class EmployeeService {
	@Autowired
	private EmployeeDao employeeDao;
	
	
	public List<Employee> getAllEmployees()
	{
		return employeeDao.getAllEmployees();
	}
	public List<Employee> getAllDepartments()
	{
		return employeeDao.getAllDepartments();
	}
	
}