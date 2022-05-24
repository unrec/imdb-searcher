package com.unrec.imdb.searcher.resolver

import com.unrec.imdb.searcher.model.Person
import com.unrec.imdb.searcher.repository.BasicRepository
import graphql.kickstart.tools.GraphQLResolver
import org.springframework.stereotype.Component

@Component
class PersonResolver(val basicRepository: BasicRepository) : GraphQLResolver<Person> {

    fun knownForTitles(person: Person) = basicRepository.findMovies(person.knownForTitles)

}