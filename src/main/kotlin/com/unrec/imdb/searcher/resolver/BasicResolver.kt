package com.unrec.imdb.searcher.resolver

import com.unrec.imdb.searcher.model.Basic
import com.unrec.imdb.searcher.model.Principal
import com.unrec.imdb.searcher.repository.PrincipalsRepository
import com.unrec.imdb.searcher.repository.RatingRepository
import graphql.kickstart.tools.GraphQLResolver
import org.springframework.stereotype.Component

@Component
class BasicResolver(
    val ratingRepository: RatingRepository,
    val principalsRepository: PrincipalsRepository,
) : GraphQLResolver<Basic> {

    fun rating(basic: Basic) = ratingRepository.findById(basic.titleId)

    fun principals(basic: Basic): List<Principal> {
        return principalsRepository.findPrincipalsByTitleId(basic.titleId)
    }

}