package com.jp.movieapi.infrastructure.persistence.actor;

import java.util.List;
import java.util.UUID;
import org.springframework.stereotype.Repository;

import com.jp.movieapi.component.actor.domain.Actor;
import com.jp.movieapi.component.actor.domain.ActorRepository;

@Repository
public class ActorRepositoryImpl implements ActorRepository {
    private final JpaActorRepository jpaActorRepository;

    public ActorRepositoryImpl(JpaActorRepository jpaActorRepository) {
        this.jpaActorRepository = jpaActorRepository;
    }

    @Override
    public List<Actor> findAllActors() {
        return jpaActorRepository.findAll();
    }

    @Override
    public Actor findActorById(UUID id) {
        return jpaActorRepository.findById(id).orElseThrow();
    }

    @Override
    public boolean existsAll(List<UUID> ids) {
        if (ids == null || ids.isEmpty()) {
            return true;
        }

        return jpaActorRepository.countByIdIn(ids) == ids.size();
    }
}
