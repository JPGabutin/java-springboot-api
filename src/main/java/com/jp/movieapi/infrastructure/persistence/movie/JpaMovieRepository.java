package com.jp.movieapi.infrastructure.persistence.movie;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaMovieRepository extends JpaRepository<MovieEntity, UUID> {
}
