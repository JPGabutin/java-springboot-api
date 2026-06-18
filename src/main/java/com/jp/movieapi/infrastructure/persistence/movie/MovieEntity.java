package com.jp.movieapi.infrastructure.persistence.movie;

import java.util.List;
import java.util.UUID;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "movies")
public class MovieEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "year", nullable = false)
    private String year;

    @Column(name = "director_id", nullable = false)
    private UUID directorId;

    @Column(name = "genre")
    private List<UUID> genre;

    @Column(name = "movie_cast")
    private List<UUID> movieCast;

    public MovieEntity(UUID id, String title, String year, UUID directorId, List<UUID> genre,
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
}

