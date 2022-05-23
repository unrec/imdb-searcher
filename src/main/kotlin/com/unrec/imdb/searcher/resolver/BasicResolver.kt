package com.unrec.imdb.searcher.resolver

import com.unrec.imdb.searcher.db.CrewTable
import com.unrec.imdb.searcher.model.Basic
import com.unrec.imdb.searcher.model.Person
import com.unrec.imdb.searcher.model.Principal
import com.unrec.imdb.searcher.repository.CrewRepository
import com.unrec.imdb.searcher.repository.NameRepository
import com.unrec.imdb.searcher.repository.PrincipalsRepository
import com.unrec.imdb.searcher.repository.RatingRepository
import graphql.kickstart.tools.GraphQLResolver
import org.jetbrains.exposed.sql.Column
import org.springframework.stereotype.Component

@Component
class BasicResolver(
    val ratingRepository: RatingRepository,
    val principalsRepository: PrincipalsRepository,
    val crewRepository: CrewRepository,
    val nameRepository: NameRepository,
) : GraphQLResolver<Basic> {

    fun rating(basic: Basic) = ratingRepository.findById(basic.titleId)

    fun principals(basic: Basic): List<Principal> =
        principalsRepository.findPrincipalsByTitleId(basic.titleId)

    fun directors(basic: Basic): List<Person>? = findCrew(basic, CrewTable.directors)
    fun writers(basic: Basic): List<Person>? = findCrew(basic, CrewTable.writers)

    private fun findCrew(basic: Basic, column: Column<String>): List<Person> {
        val ids = crewRepository.findCrewByTitleId(basic.titleId, column)
        if (ids.isNullOrEmpty()) return emptyList()

        val list = nameRepository.findByIds(ids)
        return if (list.isNullOrEmpty()) emptyList() else list
    }
}