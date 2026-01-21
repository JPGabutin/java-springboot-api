package com.jp.movieapi.component.actor.domain;

import java.util.List;
import java.util.UUID;

public interface ActorRepository {
    List<Actor> findAllActors();

    Actor findActorById(UUID id);
}
