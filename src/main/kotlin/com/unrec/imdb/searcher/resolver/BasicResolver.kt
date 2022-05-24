package com.unrec.imdb.searcher.resolver

import com.unrec.imdb.searcher.db.CrewTable
import com.unrec.imdb.searcher.model.Basic
import com.unrec.imdb.searcher.model.Person
import com.unrec.imdb.searcher.repository.DatabaseService
import graphql.kickstart.tools.GraphQLResolver
import org.jetbrains.exposed.sql.Column
import org.springframework.stereotype.Component

@Component
class BasicResolver(val databaseService: DatabaseService) : GraphQLResolver<Basic> {

    fun rating(basic: Basic) = databaseService.findRatingByTitleId(basic.titleId)
    fun principals(basic: Basic) = databaseService.findPrincipalsByTitleId(basic.titleId)

    fun directors(basic: Basic): List<Person>? = findCrew(basic, CrewTable.directors)
    fun writers(basic: Basic): List<Person>? = findCrew(basic, CrewTable.writers)

    private fun findCrew(basic: Basic, column: Column<String>): List<Person> =
        databaseService.findCrew(basic, column)
}