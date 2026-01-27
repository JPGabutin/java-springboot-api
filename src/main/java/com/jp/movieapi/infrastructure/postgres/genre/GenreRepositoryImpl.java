package com.jp.movieapi.infrastructure.postgres.genre;

import java.util.List;
import java.util.UUID;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.jp.movieapi.component.genre.domain.GenreRepository;

@Repository
public class GenreRepositoryImpl implements GenreRepository {
    private final JdbcTemplate jdbcTemplate;

    public GenreRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public enum Sql {
        EXISTS_ALL_BY_ID("SELECT COUNT(*) FROM genres WHERE id = ANY (?)");

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
    public boolean existsAll(List<UUID> ids) {
        if (ids == null || ids.isEmpty()) {
            return true;
        }

        Integer count = jdbcTemplate.queryForObject(Sql.EXISTS_ALL_BY_ID.toString(), Integer.class,
                (Object[]) ids.toArray(new UUID[0]));

        return count != null && count == ids.size();
    }
}
