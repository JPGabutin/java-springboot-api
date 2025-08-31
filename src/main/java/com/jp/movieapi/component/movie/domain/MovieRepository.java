package com.jp.movieapi.component.movie.domain;

import java.util.List;

public interface MovieRepository {
    List<Movie> findAllMovies();
}
