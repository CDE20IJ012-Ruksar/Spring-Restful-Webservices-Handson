package com.cognizant.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cognizant.exception.FavoritesEmptyException;

/**
 * 
 * @author 895076
 *
 */

@Service
public interface FavoritesService {

String addFavoritesMovie(int userId, int movieId);

List<Object> getAllFavoriteMovies(int userId) throws FavoritesEmptyException;

String removeFavoriteMovie(int userId, int movieId);

}
