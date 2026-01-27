package com.jp.movieapi.component.movie.domain;

import java.util.List;
import java.util.UUID;

public interface MovieRepository {
    List<Movie> findAllMovies();

    Movie findMovieById(UUID id);

    List<Movie> findMoviesByFilter(UUID directorId, List<UUID> actorIds, List<UUID> genreIds);

    void insert(Movie movie);
}
