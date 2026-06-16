package com.jp.movieapi.component.actor.domain;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ActorRepository {
    List<Actor> findAllActors();

    Optional<Actor> findActorById(UUID id);

    boolean existsAll(List<UUID> ids);
}
