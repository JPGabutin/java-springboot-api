package com.jp.movieapi.infrastructure.postgres.actor;

import java.util.List;
import java.util.UUID;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.jp.movieapi.component.actor.domain.Actor;
import com.jp.movieapi.component.actor.domain.ActorRepository;

@Repository
public class ActorRepositoryImpl implements ActorRepository {
    private final JdbcTemplate jdbcTemplate;

    public ActorRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public enum Sql {
        FIND_ALL_ACTORS("SELECT id, name, birth_date FROM actors"),
        FIND_ACTOR_BY_ID("SELECT id, name, birth_date FROM actors where id = ?");

        private final String query;

        Sql(String query) {
            this.query = query;
        }

        @Override
        public String toString() {
            return query;
        }
    }

    @Override
    public List<Actor> findAllActors() {
        return jdbcTemplate.query(Sql.FIND_ALL_ACTORS.toString(), (rs, rowNum) -> new Actor(
                rs.getObject("id", UUID.class),
                rs.getString("name"),
                rs.getString("birth_date")));
    }

    @Override
    public Actor findActorById(UUID id) {
        return jdbcTemplate.queryForObject(Sql.FIND_ACTOR_BY_ID.toString(),
                (rs, rowNum) -> new Actor(
                        rs.getObject("id", UUID.class),
                        rs.getString("name"),
                        rs.getString("birth_date")),
                id);
    }
}
