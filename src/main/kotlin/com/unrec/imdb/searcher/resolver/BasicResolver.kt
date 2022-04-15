package com.unrec.imdb.searcher.resolver

import com.unrec.imdb.searcher.model.Basic
import com.unrec.imdb.searcher.model.Rating
import com.unrec.imdb.searcher.repository.RatingRepository
import graphql.kickstart.tools.GraphQLResolver
import org.springframework.stereotype.Component

@Component
class BasicResolver(private val ratingRepository: RatingRepository) : GraphQLResolver<Basic> {

    fun rating(basic: Basic): Rating {
        return ratingRepository.getById(basic.titleId)
    }
}