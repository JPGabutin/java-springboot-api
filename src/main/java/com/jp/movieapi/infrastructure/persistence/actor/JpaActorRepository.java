package com.jp.movieapi.infrastructure.persistence.actor;

import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import com.jp.movieapi.component.actor.domain.Actor;

public interface JpaActorRepository extends JpaRepository<Actor, UUID> {
    long countByIdIn(List<UUID> ids);
}
