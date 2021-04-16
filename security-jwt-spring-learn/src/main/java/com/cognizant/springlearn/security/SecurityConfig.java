package com.cognizant.springlearn.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.cognizant.springlearn.SpringLearnApplication;
@Configuration 
@EnableWebSecurity 
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	private static final Logger LOGGER = LoggerFactory.getLogger(SecurityConfig.class); 
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
		.withUser("admin")
		.password(passwordEncoder().encode("pwd"))
		.roles("ADMIN")
		.and()
		.withUser("user")
		.password(passwordEncoder().encode("pwd"))
		.roles("USER");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		http
		
		.authorizeRequests()
		.antMatchers("/countries")
		.hasRole("USER")
		;
	}

		@Bean
		public PasswordEncoder passwordEncoder() {
			LOGGER.info("Start"); 
			return new BCryptPasswordEncoder(); 
		}
	}
