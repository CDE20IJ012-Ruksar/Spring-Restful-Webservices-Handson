package com.cognizant.springlearn.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.cognizant.springlearn.model.Employee;
@Component
public class EmployeeDao {
	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeDao.class);
	private static List<Employee> EMPLOYEE_LIST;
	
	public EmployeeDao(){
		LOGGER.info("Started EmployeeDao Constructor");
		ApplicationContext context=new ClassPathXmlApplicationContext("employee.xml");
		EMPLOYEE_LIST=(List<Employee>) context.getBean("employeeList",ArrayList.class);
		LOGGER.info("Ended EmployeeDao Constructor");
	}
	public List<Employee> getAllEmployees(){
		LOGGER.info("Started Fetching Employee List");
		return EMPLOYEE_LIST;
	}
	public void updateEmployee(Employee employee) throws EmployeeNotFoundException{
		LOGGER.info("Start updateEmployees");
		Employee e = null;
		for(int i=0;i<EMPLOYEE_LIST.size();i++) {
			
			
			if(EMPLOYEE_LIST.get(i).getId() == employee.getId()) {
				e= EMPLOYEE_LIST.get(i);
				EMPLOYEE_LIST.set(i, employee);
				LOGGER.debug("Employee" + EMPLOYEE_LIST.get(i) + " Updated");
			}
		}
		if(e == null) {
			throw new EmployeeNotFoundException();
		}
		LOGGER.info("Stop updateEmployees");
	}
	
	public void deleteEmployee(int id) throws EmployeeNotFoundException{
		LOGGER.info("Start deleteEmployees");
		Employee e = null;
		for(int i=0;i<EMPLOYEE_LIST.size();i++) {
			
			if(EMPLOYEE_LIST.get(i).getId() == id) {
				e= EMPLOYEE_LIST.get(i);
				EMPLOYEE_LIST.remove(i);
			}
		}
		if(e == null) {
			throw new EmployeeNotFoundException();
		}
	}
}
