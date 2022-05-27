package com.unrec.imdb.searcher.resolver

import com.unrec.imdb.searcher.model.Basic
import com.unrec.imdb.searcher.model.Movie
import com.unrec.imdb.searcher.model.Rating
import com.unrec.imdb.searcher.repository.DatabaseService
import com.unrec.imdb.searcher.repository.MovieSearchParams
import graphql.kickstart.tools.GraphQLQueryResolver
import org.springframework.stereotype.Component

@Component
class SchemaQueryResolver(private val databaseService: DatabaseService) : GraphQLQueryResolver {

    fun movie(id: Int): Basic? = databaseService.findMovieByTitleId(id)
    fun movieSearch(
        name: String?,
        director: String?,
        writer: String?,
        genre: String?,
        minRating: Float?,
        minVotes: Int?,
        limit: Int?,
    ): List<Movie> {
        val params = MovieSearchParams(name, director, writer, genre, minRating, minVotes, limit)
        return databaseService.findMoviesByParams(params)
    }

    fun rating(id: Int): Rating? = databaseService.findRatingByTitleId(id)
    fun person(name: String, profession: String?) =
        databaseService.findPersonByNameAndProfession(name, profession)
}