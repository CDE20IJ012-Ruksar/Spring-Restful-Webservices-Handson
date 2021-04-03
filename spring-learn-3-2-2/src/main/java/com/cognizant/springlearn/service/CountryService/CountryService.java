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
import com.cognizant.springlearn.service.exception.CountryNotFoundException.CountryNotFoundException;
@Service
public class CountryService {
	
	@Autowired
	Country searchedCountry;
	public Country getCountry(String code) {
		
		ApplicationContext context=new ClassPathXmlApplicationContext("country.xml");
		ArrayList<Country> countries=context.getBean("countryList",ArrayList.class);
		Map<String,String> map=new HashMap<String,String>();
		for(Country country:countries) {
			map.put(country.getCode(), country.getName());
		}
		
		Set<Entry<String,String>> set=map.entrySet();
		for(Entry<String,String> s:set) {
			if(s.getKey().equalsIgnoreCase(code)) {
				searchedCountry.setCode(s.getKey());
				searchedCountry.setName(s.getValue());
			}
			else {
				throw new CountryNotFoundException();
			}
		}
		return searchedCountry;
	
			
		

}}
