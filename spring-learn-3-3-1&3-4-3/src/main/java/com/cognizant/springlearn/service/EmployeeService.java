package com.cognizant.springlearn.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.springlearn.dao.EmployeeDao;
import com.cognizant.springlearn.dao.EmployeeNotFoundException;
import com.cognizant.springlearn.model.Employee;

@Service

public class EmployeeService {
	@Autowired
	private EmployeeDao employeeDao;
	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeService.class);
	
	public List<Employee> getAllEmployees()
	{	LOGGER.info("Start getAllEmployees");
		return employeeDao.getAllEmployees();
	}
	public void updateEmployee(Employee employee) throws EmployeeNotFoundException{
		LOGGER.info("Start updateEmployees");
		employeeDao.updateEmployee(employee);
	}
	
	public void deleteEmployee(int id) throws EmployeeNotFoundException{
		LOGGER.info("Start deleteEmployees");
		employeeDao.deleteEmployee(id);
	}
	
}
