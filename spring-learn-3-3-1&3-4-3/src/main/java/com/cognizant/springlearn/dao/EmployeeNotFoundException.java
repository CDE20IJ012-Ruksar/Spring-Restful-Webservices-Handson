package com.cognizant.springlearn.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.context.request.WebRequest;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;

public class EmployeeNotFoundException extends Exception {
	protected ResponseEntity<Map<String, Object>> handleHttpMessageNotReadable( 
			HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, 
			WebRequest request) { 
			Map<String, Object> body = new LinkedHashMap<>(); 
			body.put("timestamp", new Date()); 
			body.put("status", status.value()); 
			body.put("error", "Bad Request"); 

			List<String> errors = new ArrayList<String>(); 
			if (ex.getCause() instanceof InvalidFormatException) { 
			final Throwable cause = ex.getCause() == null ? ex : ex.getCause(); 
			for (InvalidFormatException.Reference reference : ((InvalidFormatException) cause).getPath()) { 
			body.put("message", "Incorrect format for field '" + reference.getFieldName() + "'"); 
			} 
			} 

			return new ResponseEntity<>(body, headers, status); 
			}
}
