package com.unrec.imdb.searcher.resolver

import com.unrec.imdb.searcher.model.Basic
import com.unrec.imdb.searcher.model.Rating
import com.unrec.imdb.searcher.repository.DatabaseService
import graphql.kickstart.tools.GraphQLQueryResolver
import org.springframework.stereotype.Component

@Component
class SchemaQueryResolver(private val databaseService: DatabaseService) : GraphQLQueryResolver {

    fun movie(id: Int): Basic? = databaseService.findMovieByTitleId(id)
    fun rating(id: Int): Rating? = databaseService.findRatingByTitleId(id)
    fun person(name: String, profession: String?) =
        databaseService.findPersonByNameAndProfession(name, profession)
}