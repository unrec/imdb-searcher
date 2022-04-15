# imdb-searcher

### Sample queries

**Request**
```graphql
{
  movie(id: 110912) {
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