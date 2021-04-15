package com.cognizant.springlearn;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class SpringLearnApplication {

	public static void main(String[] args) throws ParseException {
		SpringApplication.run(SpringLearnApplication.class, args);
		displayDate();
	}
	public static void displayDate() throws ParseException {
	ApplicationContext context = new ClassPathXmlApplicationContext("date-format.xml"); 
	SimpleDateFormat format = context.getBean("dateFormat", SimpleDateFormat.class); 
	System.out.println(format.parse("31/12/2018"));
	}
}
