package com.jp.movieapi.component.actor.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.jp.movieapi.component.actor.domain.Actor;
import com.jp.movieapi.component.actor.domain.ActorRepository;

@Service
public class ActorServiceImpl implements ActorService {
    public final ActorRepository actorRepository;

    public ActorServiceImpl(ActorRepository actorRepository) {
        this.actorRepository = actorRepository;
    }

    @Override
    public List<Actor> listAllActors() {
        return actorRepository.findAllActors();
    }

    @Override
    public Actor getActorById(UUID id) {
        return actorRepository.findActorById(id);
    }
}
