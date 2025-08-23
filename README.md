# App: Movie DB API

## Description:

-   Allow visitors to sign up/register.
-   Allows user to browse through collection of movies.
-   Allows user to search through collection using field or property (i.e.,
    director, cast member, title, etc).
-   Allows admins to create new and edit models.

## Models

### USER

-   id - string
-   username - string
-   email - string
-   password - string
-   isAdmin - boolean
-   createdAt - string
-   favoriteMovies - array of strings

### MOVIE

-   id - string
-   title - string
-   year - string
-   director - string
-   genre - array of strings (genre names/ids)
-   cast - array of strings (artist names/ids)

### DIRECTOR

-   id - string
-   name - string
-   birthDate - string
-   movies - array of strings (genre names/ids)

### ACTOR

-   id - string
-   name - string
-   birthDate - string
-   movies - array of strings (genre names/ids)

### GENRE

-   id - string
-   type - string
-   description - string

## Getting Started

### Clone the project

```bash
$ git clone git@github.com:JPGabutin/java-springboot-api.git
$ cd java-springboot-api
```

### Install dependencies

```bash
$ mvn clean install
```

### Run database migrations

* For local db

```bash
$ mvn flyway:migrate
```

* Replace config to change database target

```bash
mvn flyway:migrate \
  -Dflyway.url=jdbc:postgresql://localhost:5432/moviedb \
  -Dflyway.user=dev \
  -Dflyway.password=dev
```

### Start the app

```bash
mvn spring-boot:run
```

### Clean up local db

```bash
docker compose down --volumes --remove-orphans
```


### Clean up flyway migrations

```bash
mvn flyway:clean
```

### Delete and rebuild target directory

```bash
mvn clean package
```
