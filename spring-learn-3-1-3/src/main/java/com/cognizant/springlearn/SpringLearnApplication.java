package com.cognizant.springlearn;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import org.slf4j.Logger; 
import org.slf4j.LoggerFactory; 
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cognizant.springlearn.Country.Country;

@SpringBootApplication
public class SpringLearnApplication {
	private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class); 
	public static void main(String[] args) {
		SpringApplication.run(SpringLearnApplication.class, args);
		displayDate();
		displayCountry();
		displayCountries();
	}
	public static void displayDate() {
	ApplicationContext context = new ClassPathXmlApplicationContext("date-format.xml");
	LOGGER.info("START");
	SimpleDateFormat format = context.getBean("dateFormat", SimpleDateFormat.class); 
	System.out.println(format);
	LOGGER.info("END");
	}
	
	public static void displayCountry() {
	ApplicationContext context = new ClassPathXmlApplicationContext("country.xml"); 
	LOGGER.info("START");
    Country country = (Country) context.getBean("in", Country.class); 
    Country anotherCountry = (Country)context.getBean("in", Country.class); 
	LOGGER.debug("Country : {}", country.toString()); 
	LOGGER.info("END");
	}
	
	public static void displayCountries() {
		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml"); 
		LOGGER.info("START");
	    ArrayList countries =  context.getBean("countryList", ArrayList.class); 
	    LOGGER.debug("Country : {}", countries.toString()); 
		LOGGER.info("END");
	}
	
	
}
