package com.jp.movieapi.component.movie.domain;

import java.util.List;
import java.util.UUID;

public class Movie {
    private UUID id;
    private String title;
    private String year;
    private UUID director_id;
    private List<UUID> genre;
    private List<UUID> movie_cast;

    public Movie(UUID id, String title, String year, UUID directorId, List<UUID> genre, List<UUID> movieCast) {
        this.id = id;
        this.title = title;
        this.year = year;
        this.director_id = directorId;
        this.genre = genre;
        this.movie_cast = movieCast;
    }

    public UUID getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getYear() {
        return year;
    }

    public UUID getDirectorId() {
        return director_id;
    }

    public List<UUID> getGenre() {
        return genre;
    }

    public List<UUID> getMovieCast() {
        return movie_cast;
    }
}
