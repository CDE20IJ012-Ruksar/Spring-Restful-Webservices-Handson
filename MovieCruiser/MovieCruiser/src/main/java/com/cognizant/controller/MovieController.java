package com.cognizant.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.model.Movie;
import com.cognizant.service.MovieService;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @author 895076
 *
 */
@RestController
@RequestMapping("/movies")
@Slf4j
public class MovieController {
@Autowired
MovieService service;

/**
 * 
 * @return list of movies
 */
@GetMapping("/admin")
public List<Movie> getMovieListAdmin() {
	log.info("start");
	log.debug("fetching all movie list for admin");
	List<Movie> movieList = service.getMovieListAdmin();
	log.debug("Movies {}", movieList);
	log.info("end");
	return movieList;
}

/**
 * 
 * @return all movies released
 */
@GetMapping("/customer")
public List<Movie> getMovieListCustomer() {
	log.info("start");
	log.info("fetching customer movie list");
	List<Movie> movieList = service.getMovieListCustomer();
	log.debug("Movies {}", movieList);
	log.info("end");
	
	return movieList;
}

/**
 * 
 * @param movieId
 * @return movie with the given Id
 */
@GetMapping("/{movieId}")
public Movie getMovie(@PathVariable int movieId) {
	log.info("start");
	log.debug("getting movie by id ");
	Movie movie = service.getMovie(movieId);
	log.debug("Movie {}", movie);
	log.info("end");
	return movie;
}

/**
 * 
 * @param movie
 * @return success / failure message after editing the movie
 */
@PutMapping("/editMovie")
public String modifyMovie(@RequestBody Movie movie) {
	log.info("start edit movie ");
	String message = service.modifyMovie(movie);
	log.debug(message);
	log.info("Ended");
	return message;
}
}