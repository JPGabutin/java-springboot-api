package com.jp.movieapi.component.genre.domain;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Repository;

@Repository
public interface GenreRepository {
    boolean existsAll(List<UUID> ids);
}
