package com.cognizant.springlearn.controller.CountryController;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.springlearn.Country.Country;
import com.cognizant.springlearn.service.CountryService.CountryService;
import com.cognizant.springlearn.service.exception.CountryNotFoundException.CountryNotFoundException;

@RestController
@RequestMapping("")
public class CountryController {
	@Autowired
	CountryService countryService;
	
	@GetMapping("/country")
	public Country getCountryIndia() {
		ApplicationContext context=new ClassPathXmlApplicationContext("country.xml");
		Country country=(Country) context.getBean("in",Country.class);
		return country;
	}
	@GetMapping("/countries")
	public ArrayList getAllCountries() {
		ApplicationContext context=new ClassPathXmlApplicationContext("country.xml");
		ArrayList countries=context.getBean("countryList",ArrayList.class);
		return countries;
	}
	
	@GetMapping("/countries/{code}")
	public Country getCountry(@PathVariable String code) throws CountryNotFoundException{
		
		 return countryService.getCountry(code);
	}
	
}
