package com.unrec.imdb.searcher.resolver

import com.unrec.imdb.searcher.model.Basic
import com.unrec.imdb.searcher.model.Rating
import com.unrec.imdb.searcher.repository.BasicRepository
import com.unrec.imdb.searcher.repository.NameRepository
import com.unrec.imdb.searcher.repository.RatingRepository
import graphql.kickstart.tools.GraphQLQueryResolver
import org.springframework.stereotype.Component

@Component
class SchemaQueryResolver(
    private val basicRepository: BasicRepository,
    private val ratingRepository: RatingRepository,
    private val nameRepository: NameRepository
) : GraphQLQueryResolver {

    fun movie(id: Int): Basic? = basicRepository.findMovieById(id)
    fun rating(id: Int): Rating? = ratingRepository.findById(id)
    fun person(name: String, profession: String?) = nameRepository.findPerson(name, profession)
}