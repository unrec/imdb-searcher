package com.unrec.imdb.searcher.resolver

import com.unrec.imdb.searcher.model.Basic
import com.unrec.imdb.searcher.model.Rating
import com.unrec.imdb.searcher.repository.BasicRepository
import com.unrec.imdb.searcher.repository.RatingRepository
import graphql.kickstart.tools.GraphQLQueryResolver
import org.springframework.stereotype.Component

@Component
class SchemaQueryResolver(
    private val basicRepository: BasicRepository,
    private val ratingRepository: RatingRepository
) : GraphQLQueryResolver {
    fun movie(id: Int): Basic? = basicRepository.findMovieById(id)
    fun rating(id: Int): Rating? = ratingRepository.findById(id)
}