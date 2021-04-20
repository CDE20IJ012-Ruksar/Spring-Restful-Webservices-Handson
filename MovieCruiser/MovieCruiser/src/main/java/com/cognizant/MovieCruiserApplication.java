package com.cognizant;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @author 895076 Movie Cruiser Application
 *
 */
@SpringBootApplication
@Slf4j
public class MovieCruiserApplication {

public static void main(String[] args) {
	log.info("start application");
	SpringApplication.run(MovieCruiserApplication.class, args);
}

}
