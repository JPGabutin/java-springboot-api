package com.jp.movieapi.internal.api.controllers.movie;

import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jp.movieapi.component.movie.domain.Movie;
import com.jp.movieapi.component.movie.service.MovieService;
import com.jp.movieapi.infrastructure.persistence.movie.MovieEntity;
import com.jp.movieapi.internal.api.controllers.movie.dto.GetMovieResponse;

@RestController
@RequestMapping("/api/movies")
public class MovieController {
    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    public ResponseEntity<List<Movie>> getAllMovies() {
        List<Movie> movies = movieService.listAllMovies();
        return ResponseEntity.ok(movies);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable UUID id) {
        Movie movie = movieService.getMovieById(id);
        return ResponseEntity.ok(movie);
    }

    @GetMapping("/filter")
    public ResponseEntity<List<Movie>> getMoviesByFilter(
            @RequestParam(required = false) UUID directorId,
            @RequestParam(required = false) List<UUID> actorIds,
            @RequestParam(required = false) List<UUID> genreIds) {
        List<Movie> movies = movieService.getMoviesByFilter(directorId, actorIds, genreIds);
        return ResponseEntity.ok(movies);
    }

    private GetMovieResponse toGetMovieResponse(Movie movie) {
        GetMovieResponse movieResponse =
                new GetMovieResponse(movie.getId(), movie.getTitle(),
                        movie.getYear(),
                        movie.getDirectorId());

        if (!movie.getGenre().isEmpty()) {
            movieResponse.setGenre(movie.getGenre());
        }

        if (!movie.getMovieCast().isEmpty()) {
            movieResponse.setMovieCast(movie.getMovieCast());
        }

        return movieResponse;
    }
}
