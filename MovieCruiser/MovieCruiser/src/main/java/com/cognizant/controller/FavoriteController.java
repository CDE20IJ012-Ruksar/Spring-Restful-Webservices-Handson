package com.cognizant.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.exception.FavoritesEmptyException;
import com.cognizant.service.FavoritesService;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @author 895076
 *
 */
@RestController
@RequestMapping("/favorites")
@Slf4j
public class FavoriteController {

@Autowired
FavoritesService service;

/**
 * 
 * @param userId
 * @param movieId
 * @return message after adding favorite movie
 */
@PostMapping("/{userId}/{movieId}")
public String addFavoritesMovie(@PathVariable int userId, @PathVariable int movieId) {
	log.info("started");
	log.debug("started adding movie to favourites");
	String movies = service.addFavoritesMovie(userId, movieId);
	log.info("ended");
	return movies;
}

/**
 * 
 * @param userId
 * @return list all of favorite movies for user id
 * @throws FavoritesEmptyException
 */
@GetMapping("/{userId}")
public List<Object> getAllFavoriteMovies(@PathVariable int userId) throws FavoritesEmptyException {
	log.info("start");
	log.debug("fetching list of all favourite movies ");
	List<Object> movieList = service.getAllFavoriteMovies(userId);
	log.debug("Favorite Movies {}", movieList);
	log.info("end");
	return movieList;
}

/**
 * 
 * @param userId
 * @param movieId
 * @return message after deleting the movie
 */
@DeleteMapping("/{userId}/{movieId}")
public String deleteFavoriteMovie(@PathVariable int userId, @PathVariable int movieId) {
	log.info("start delete");
	String message = service.removeFavoriteMovie(userId, movieId);
	log.debug("delete service started");
	log.info("end");
	return message;
}

}