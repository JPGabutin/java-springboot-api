package com.jp.movieapi.infrastructure.postgres.movie;

import java.sql.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
        FIND_ALL_MOVIES("SELECT id, title, year, director_id, genre, movie_cast FROM movies"),
        FIND_MOVIE_BY_ID("SELECT id, title, year, director_id, genre, movie_cast FROM movies where id = ?"),
        FIND_MOVIES_BY_FILTER("SELECT id, title, year, director_id, genre, movie_cast FROM movies where 1 = 1");

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

    @Override
    public Movie findMovieById(UUID id) {
        return jdbcTemplate.queryForObject(Sql.FIND_MOVIE_BY_ID.toString(),
                (rs, rowNum) -> new Movie(
                        rs.getObject("id", UUID.class),
                        rs.getString("title"),
                        rs.getString("year"),
                        rs.getObject("director_id", UUID.class),
                        Arrays.asList((UUID[]) rs.getArray("genre").getArray()),
                        Arrays.asList((UUID[]) rs.getArray("movie_cast").getArray())),
                id);
    }

    @Override
    public List<Movie> findMoviesByFilter(UUID directorId, List<UUID> actorIds, List<UUID> genreIds) {
        StringBuilder sql = new StringBuilder(Sql.FIND_MOVIES_BY_FILTER.toString());
        List<Object> params = new ArrayList<>();

        if (directorId != null) {
            sql.append(" AND director_id = ?");
            params.add(directorId);
        }

        if (actorIds != null && !actorIds.isEmpty()) {
            sql.append(" AND movie_cast @> ?");
            params.add(actorIds.toArray(new UUID[0]));
        }

        if (genreIds != null && !genreIds.isEmpty()) {
            sql.append(" AND genre @> ?");
            params.add(genreIds.toArray(new UUID[0]));
        }

        return jdbcTemplate.query(sql.toString(), this::mapRowToMovie, params.toArray());
    }

    private Movie mapRowToMovie(ResultSet rs, int rowNum) throws SQLException {
        return new Movie(
                rs.getObject("id", UUID.class),
                rs.getString("title"),
                rs.getString("year"),
                rs.getObject("director_id", UUID.class),
                mapUuidArray(rs, "genre"),
                mapUuidArray(rs, "movie_cast"));
    }

    private List<UUID> mapUuidArray(ResultSet rs, String column) throws SQLException {
        Array array = rs.getArray(column);
        return array == null ? List.of() : Arrays.asList((UUID[]) array.getArray());
    }
}
