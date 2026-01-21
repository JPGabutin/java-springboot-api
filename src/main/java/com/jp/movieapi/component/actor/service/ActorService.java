package com.jp.movieapi.component.actor.service;

import java.util.List;
import java.util.UUID;

import com.jp.movieapi.component.actor.domain.Actor;

public interface ActorService {
    List<Actor> listAllActors();

    Actor getActorById(UUID id);
}
