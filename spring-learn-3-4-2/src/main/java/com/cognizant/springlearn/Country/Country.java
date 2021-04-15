package com.cognizant.springlearn.Country;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;
@Entity
public class Country {
	private static final Logger LOGGER = LoggerFactory.getLogger(Country.class);
	@Id
	@NotNull 
	@Size(min=2, max=2, message="Country code should be 2 characters") 
	private String code; 
	private String name;
	public Country() {
		LOGGER.debug("Inside Country Constructor");
		// TODO Auto-generated constructor stub
	}
	public String getCode() {
		LOGGER.debug("Get Country Code");
		return code;
	}
	public void setCode(String code) {
		LOGGER.debug("Set Country Code");
		this.code = code;
	}
	public String getName() {
		LOGGER.debug("Get Country Name");
		return name;
	}
	public void setName(String name) {
		LOGGER.debug("Set Country Name");
		this.name = name;
	}
	@Override
	public String toString() {
		return "Country [code=" + code + ", name=" + name + "]";
	}
	
}
