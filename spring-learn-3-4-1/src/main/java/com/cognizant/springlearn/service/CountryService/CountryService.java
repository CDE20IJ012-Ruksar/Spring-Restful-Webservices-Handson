package com.cognizant.springlearn.service.CountryService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.cognizant.springlearn.SpringLearnApplication;
import com.cognizant.springlearn.Country.Country;
import com.cognizant.springlearn.dao.CountryRepository.CountryRepository;
import com.cognizant.springlearn.service.exception.CountryNotFoundException.CountryNotFoundException;
@Service
public class CountryService {
	
	@Autowired
	private CountryRepository countryRepository;
	public Country addCountry(Country country) {
		return countryRepository.save(country);
		
	
		}
	
}
