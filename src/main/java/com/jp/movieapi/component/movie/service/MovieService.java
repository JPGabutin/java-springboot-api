package com.jp.movieapi.component.movie.service;

import java.util.List;
import java.util.UUID;

import com.jp.movieapi.component.movie.domain.Movie;
import com.jp.movieapi.internal.api.controllers.movie.dto.CreateMovieRequest;

public interface MovieService {
    List<Movie> listAllMovies();

    Movie getMovieById(UUID id);

    List<Movie> getMoviesByFilter(UUID directorId, List<UUID> actorIds, List<UUID> genreIds);

    void createMovie(CreateMovieRequest request);
}
