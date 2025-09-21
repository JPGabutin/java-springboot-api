package com.jp.movieapi.component.movie.service;

import java.util.List;
import java.util.UUID;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.jp.movieapi.common.domain.ResourceNotFoundException;
import com.jp.movieapi.component.movie.domain.Movie;
import com.jp.movieapi.component.movie.domain.MovieRepository;

@Service
public class MovieServiceImpl implements MovieService {
    public final MovieRepository movieRepository;

    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public List<Movie> listAllMovies() {
        return movieRepository.findAllMovies();
    }

    @Override
    public Movie getMovieById(UUID id) {
        try {
            return movieRepository.findMovieById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException("Movie", id);
        }
    }
}
