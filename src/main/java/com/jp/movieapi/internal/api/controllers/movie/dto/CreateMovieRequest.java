package com.jp.movieapi.internal.api.controllers.movie.dto;

import java.util.List;
import java.util.UUID;

public record CreateMovieRequest(UUID id, String title, String year, UUID directorId, List<UUID> genre,
        List<UUID> movieCast) {
};
