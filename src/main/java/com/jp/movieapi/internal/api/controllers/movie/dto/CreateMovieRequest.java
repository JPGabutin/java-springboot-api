package com.jp.movieapi.internal.api.controllers.movie.dto;

import java.util.List;
import java.util.UUID;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreateMovieRequest(
        @NotBlank String title,

        @NotBlank String year,

        @NotNull UUID directorId,

        List<UUID> genre,

        List<UUID> movieCast) {
};
