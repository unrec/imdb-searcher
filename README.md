# imdb-searcher

### Database initialization

Use **[imdb-loader](https://github.com/unrec/imdb-loader)** for loading IMDb datasets to PostgreSQL database.

###

API is described in the GraphQL **[schema](src/main/resources/graphql/schema.graphqls)**.

Basically you can search movies by some basic parameters, as well search a **movie**, a **rating**, or a **person** by *titleId*.

### Sample queries

**Movie search request**
```graphql
{
    movieSearch(genre: "Film-Noir", director: "Billy Wilder", limit: 20, minRating: 7) {
        title
        year
        directors
        rating
        votes
    }
}
```

**Response**
```graphql
{
  "data": {
    "movieSearch": [
      {
        "title": "Sunset Blvd.",
        "year": 1950,
        "directors": "Billy Wilder",
        "rating": 8.4,
        "votes": 214401
      },
      {
        "title": "Double Indemnity",
        "year": 1944,
        "directors": "Billy Wilder",
        "rating": 8.3,
        "votes": 152101
      },
      {
        "title": "Ace in the Hole",
        "year": 1951,
        "directors": "Billy Wilder",
        "rating": 8.1,
        "votes": 34644
      },
      {
        "title": "The Lost Weekend",
        "year": 1945,
        "directors": "Billy Wilder",
        "rating": 7.9,
        "votes": 35886
      }
    ]
  }
}
```

**Movie by titleId request**
```graphql
{
  movie(titleId: 110912) {
    titleType
    originalTitle
    startYear
    runtimeMinutes
    genres
    rating {
      numVotes
      averageRating
    }
  }
}
```

**Response**
```graphql
{
  "data": {
    "movie": {
      "titleType": "movie",
      "originalTitle": "Pulp Fiction",
      "startYear": 1994,
      "runtimeMinutes": 154,
      "genres": "Crime,Drama",
      "rating": {
        "numVotes": 1946783,
        "averageRating": 8.9
      }
    }
  }
}
```