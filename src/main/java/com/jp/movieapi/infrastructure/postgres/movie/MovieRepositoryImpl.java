package com.jp.movieapi.infrastructure.postgres.movie;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.jp.movieapi.component.movie.domain.Movie;
import com.jp.movieapi.component.movie.domain.MovieRepository;

@Repository
public class MovieRepositoryImpl implements MovieRepository {

    private final JdbcTemplate jdbcTemplate;

    public MovieRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public enum Sql {
        FIND_ALL_MOVIES("SELECT id, title, year, director_id, genre, movie_cast FROM movies");

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
    public List<Movie> findAllMovies() {
        return jdbcTemplate.query(Sql.FIND_ALL_MOVIES.toString(), (rs, rowNum) -> new Movie(
                rs.getObject("id", UUID.class),
                rs.getString("title"),
                rs.getString("year"),
                rs.getObject("director_id", UUID.class),
                Arrays.asList((UUID[]) rs.getArray("genre").getArray()),
                Arrays.asList((UUID[]) rs.getArray("movie_cast").getArray())));
    }
}
