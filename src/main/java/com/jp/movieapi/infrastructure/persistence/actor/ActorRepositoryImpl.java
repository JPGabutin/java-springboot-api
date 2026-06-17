package com.jp.movieapi.infrastructure.persistence.actor;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
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
        List<ActorEntity> actors = jpaActorRepository.findAll();
        return actors.stream().map(this::toDomain).collect(Collectors.toList());
    }

    @Override
    public Optional<Actor> findActorById(UUID id) {
        return jpaActorRepository.findById(id).map(this::toDomain);
    }

    @Override
    public boolean existsAll(List<UUID> ids) {
        if (ids == null || ids.isEmpty()) {
            return true;
        }

        return jpaActorRepository.countByIdIn(ids) == ids.size();
    }

    private Actor toDomain(ActorEntity actorEntity) {
        return new Actor(actorEntity.getId(), actorEntity.getName(), actorEntity.getBirthDate());
    }
}
