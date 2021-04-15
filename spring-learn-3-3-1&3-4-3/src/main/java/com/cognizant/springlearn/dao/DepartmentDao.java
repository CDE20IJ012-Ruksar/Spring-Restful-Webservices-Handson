package com.cognizant.springlearn.dao;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.cognizant.springlearn.model.Department;


@Component
public class DepartmentDao {
	private static final Logger LOGGER = LoggerFactory.getLogger(DepartmentDao.class);
	
	private static List<Department> DEPARTMENT_LIST;
	public DepartmentDao(){
		LOGGER.info("Started DepartmentDao Constructor");
		ApplicationContext context=new ClassPathXmlApplicationContext("employee.xml");
		DEPARTMENT_LIST=(List<Department>) context.getBean("departmentList",ArrayList.class);
		LOGGER.info("Ended DepartmentDao Constructor");
	}
	
	public List<Department> getAllDepartments(){
		LOGGER.info("Started Fetching Department List");
		return DEPARTMENT_LIST;
	}
	
}

