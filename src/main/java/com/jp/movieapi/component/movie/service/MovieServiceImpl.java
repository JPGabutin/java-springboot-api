package com.jp.movieapi.component.movie.service;

import java.util.List;
import java.util.UUID;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jp.movieapi.internal.api.controllers.movie.dto.CreateMovieRequest;
import com.jp.movieapi.internal.common.domain.ResourceNotFoundException;
import com.jp.movieapi.component.actor.domain.ActorRepository;
import com.jp.movieapi.component.genre.domain.GenreRepository;
import com.jp.movieapi.component.movie.domain.Movie;
import com.jp.movieapi.component.movie.domain.MovieRepository;

@Service
public class MovieServiceImpl implements MovieService {
    public final MovieRepository movieRepository;
    public final GenreRepository genreRepository;
    public final ActorRepository actorRepository;

    public MovieServiceImpl(MovieRepository movieRepository, GenreRepository genreRepository,
            ActorRepository actorRepository) {
        this.movieRepository = movieRepository;
        this.genreRepository = genreRepository;
        this.actorRepository = actorRepository;
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

    @Override
    public List<Movie> getMoviesByFilter(UUID directorId, List<UUID> actorIds, List<UUID> genreIds) {
        if (directorId == null && (actorIds == null || actorIds.isEmpty())
                && (genreIds == null || genreIds.isEmpty())) {
            throw new IllegalArgumentException("At least one filter must be provided");
        }

        return movieRepository.findMoviesByFilter(directorId, actorIds, genreIds);
    }

    @Override
    @Transactional
    public void createMovie(CreateMovieRequest request) {
        List<UUID> genres = request.genre() == null ? List.of() : request.genre();
        List<UUID> cast = request.movieCast() == null ? List.of() : request.movieCast();

        if (!genreRepository.existsAll(genres)) {
            throw new IllegalArgumentException("Invalid genre IDs");
        }

        if (!actorRepository.existsAll(cast)) {
            throw new IllegalArgumentException("Invalid cast IDs");
        }

        Movie movie = new Movie(
                UUID.randomUUID(),
                request.title(),
                request.year(),
                request.directorId(),
                genres,
                cast);

        movieRepository.insert(movie);
    }
}
