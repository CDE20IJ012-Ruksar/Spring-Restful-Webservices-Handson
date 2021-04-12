package com.cognizant.springlearn.dao;


import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.cognizant.springlearn.model.Employee;
@Component
public class EmployeeDao {
	private static List<Employee> EMPLOYEE_LIST;
	private static List<Employee> DEPARTMENT_LIST;
	public EmployeeDao(){
		ApplicationContext context=new ClassPathXmlApplicationContext("employee.xml");
		EMPLOYEE_LIST=(List<Employee>) context.getBean("employeeList",ArrayList.class);
	}
	public List<Employee> getAllEmployees(){
		return EMPLOYEE_LIST;
	}
	public List<Employee> getAllDepartments(){
		ApplicationContext context=new ClassPathXmlApplicationContext("employee.xml");
		DEPARTMENT_LIST=(List<Employee>) context.getBean("departmentList",ArrayList.class);
		return DEPARTMENT_LIST;
	}
	
}
