package com.jp.movieapi.internal.api.controllers.movie.dto;

import java.util.List;
import java.util.UUID;

public class GetMovieResponse {
    private UUID id;
    private String title;
    private String year;
    private UUID directorId;
    private List<UUID> genre;
    private List<UUID> movieCast;

    public GetMovieResponse(UUID id, String title, String year, UUID directorId) {
        this.id = id;
        this.title = title;
        this.year = year;
        this.directorId = directorId;
    }

    public GetMovieResponse(UUID id, String title, String year, UUID directorId, List<UUID> genre,
            List<UUID> movieCast) {
        this.id = id;
        this.title = title;
        this.year = year;
        this.directorId = directorId;
        this.genre = genre;
        this.movieCast = movieCast;
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
        return directorId;
    }

    public List<UUID> getGenre() {
        return genre;
    }

    public List<UUID> getMovieCast() {
        return movieCast;
    }

    public void setGenre(List<UUID> genre) {
        this.genre = genre;
    }

    public void setMovieCast(List<UUID> movieCast) {
        this.movieCast = movieCast;
    }

}
