package com.jp.movieapi.component.movie.domain;

import java.util.List;
import java.util.UUID;

public interface MovieRepository {
    List<Movie> findAllMovies();

    Movie findMovieById(UUID id);
}
