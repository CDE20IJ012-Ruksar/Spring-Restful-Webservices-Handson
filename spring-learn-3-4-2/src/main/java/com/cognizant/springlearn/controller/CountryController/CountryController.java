package com.cognizant.springlearn.controller.CountryController;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.cognizant.springlearn.Country.Country;
import com.cognizant.springlearn.service.CountryService.CountryService;
import com.cognizant.springlearn.service.exception.CountryNotFoundException.CountryNotFoundException;

@RestController
@RequestMapping("/sample.api.com/app-name")
public class CountryController {
	@Autowired
	private CountryService countryService;
	private static final Logger LOGGER = LoggerFactory.getLogger(CountryController.class); 
	
	@PostMapping("/countries")
	public Country addCountry(@RequestBody @Valid Country country) {
		LOGGER.debug("Start");
		
		return countryService.addCountry(country);
	}
	
	
}
