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
