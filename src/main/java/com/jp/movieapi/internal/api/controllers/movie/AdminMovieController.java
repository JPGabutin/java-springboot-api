package com.jp.movieapi.internal.api.controllers.movie;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.jp.movieapi.component.movie.service.MovieService;
import com.jp.movieapi.internal.api.controllers.movie.dto.CreateMovieRequest;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/admin/movies")
public class AdminMovieController {
    private final MovieService movieService;

    public AdminMovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @PostMapping
    public ResponseEntity<Void> createMovie(@Valid @RequestBody CreateMovieRequest request) {
        movieService.createMovie(request);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteMovie(@PathVariable UUID id) {
        movieService.deleteMovie(id);
    }
}
