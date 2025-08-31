package com.jp.movieapi.component.movie.service;

import java.util.List;

import com.jp.movieapi.component.movie.domain.Movie;

public interface MovieService {
    List<Movie> listAllMovies();
}
