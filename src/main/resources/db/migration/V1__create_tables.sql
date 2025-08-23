CREATE EXTENSION IF NOT EXISTS "pgcrypto";

CREATE TABLE genres (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    type TEXT NOT NULL,
    description TEXT
);

CREATE TABLE actors (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    name TEXT NOT NULL,
    birth_date DATE NOT NULL
);

CREATE TABLE directors (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    name TEXT NOT NULL,
    birth_date DATE NOT NULL
);

CREATE TABLE movies (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    title TEXT NOT NULL,
    year TEXT NOT NULL,
    director_id UUID REFERENCES directors(id),
    genre UUID[] NOT NULL,
    movie_cast UUID[] NOT NULL
);

CREATE TABLE app_users (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    username TEXT NOT NULL,
    email TEXT NOT NULL UNIQUE,
    password TEXT NOT NULL,
    is_admin BOOLEAN DEFAULT FALSE,
    created_at TIMESTAMP DEFAULT NOW(),
    favorite_movies UUID[]
);

