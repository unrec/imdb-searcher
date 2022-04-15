package com.unrec.imdb.searcher.resolver

import com.unrec.imdb.searcher.exception.DataNotFoundException
import com.unrec.imdb.searcher.model.Basic
import com.unrec.imdb.searcher.model.Element.BASIC
import com.unrec.imdb.searcher.model.Element.RATING
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

    fun movie(id: Int): Basic? {
        return basicRepository.findById(id)
            .orElseThrow { DataNotFoundException(BASIC, id) }
    }

    fun rating(id: Int): Rating? {
        return ratingRepository.findById(id)
            .orElseThrow { DataNotFoundException(RATING, id) }
    }
}