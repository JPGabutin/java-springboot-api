package com.jp.movieapi.infrastructure.persistence.actor;

import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaActorRepository extends JpaRepository<ActorEntity, UUID> {
    long countByIdIn(List<UUID> ids);
}
