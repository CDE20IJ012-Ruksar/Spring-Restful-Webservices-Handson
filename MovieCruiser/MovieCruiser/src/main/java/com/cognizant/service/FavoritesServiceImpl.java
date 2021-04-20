package com.cognizant.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.Dao.FavoritesDao;
import com.cognizant.Dao.MovieDao;
import com.cognizant.Dao.UserDao;
import com.cognizant.exception.FavoritesEmptyException;
import com.cognizant.model.Favorites;
import com.cognizant.model.Movie;
import com.cognizant.model.User;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @author 895076
 *
 */
@Service
@Slf4j
public class FavoritesServiceImpl implements FavoritesService {

@Autowired
private FavoritesDao favoriteDao;
@Autowired
private MovieDao movieDao;
@Autowired
private UserDao userDao;

/**
 * 
 * @param userId
 * @param movieId
 * @return Success/failure message after adding favorite movie
 */
@Override
public String addFavoritesMovie(int userId, int movieId) {
	log.info("start");
	log.debug("add movie to favorites");
	Optional<Movie> movieList = movieDao.findById(movieId);
	if (movieList.isPresent()) {
		User user = userDao.findById(userId).get();
		Favorites favorite = new Favorites(movieList.get(), user);
		favoriteDao.save(favorite);
		return "Movie added Successfully";
	}
	log.info("end");
	return "Movie Not Found";
	
}

/**
 * 
 * @param userId
 * @return List of favorite movies for user id
 * @throws FavoritesEmptyException
 */
@Override
public List<Object> getAllFavoriteMovies(int userId) throws FavoritesEmptyException {
	log.info("start");
	log.debug("get all favorite movies");
	List<Object> listMovies = favoriteDao.getItems(userId);
	if (listMovies.isEmpty()) {
		throw new FavoritesEmptyException("No Favorites added yet");
	}
	log.info("end");
	return listMovies;
}

/**
 * 
 * @param userId
 * @param movieId
 * @return success / failure message after deleting the movie
 */
@Override
public String removeFavoriteMovie(int userId, int movieId) {
	log.info("start");
	log.info("removing movie from favorites");
	Optional<Movie> movie = movieDao.findById(movieId);
	if (movie.isPresent()) {
		favoriteDao.deleteFromFav(userId, movieId);
		log.info("Ended");
		return "Movie Successfully deleted";
	}
	log.info("end");
	return "Movie Not found";
}

}
