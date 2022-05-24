package com.unrec.imdb.searcher.repository

import com.unrec.imdb.searcher.model.Basic
import com.unrec.imdb.searcher.model.Person
import org.jetbrains.exposed.sql.Column
import org.springframework.stereotype.Service

@Service
class DatabaseService(
    private val basicRepository: BasicRepository,
    private val crewRepository: CrewRepository,
    private val nameRepository: NameRepository,
    private val principalsRepository: PrincipalsRepository,
    private val ratingRepository: RatingRepository,
) {
    fun findMovieByTitleId(id: Int) = basicRepository.findById(id)

    fun findCrew(basic: Basic, column: Column<String>): List<Person> {
        val ids = crewRepository.findCrewByTitleId(basic.titleId, column)
        if (ids.isNullOrEmpty()) return emptyList()

        val list = nameRepository.findByIds(ids)
        return if (list.isNullOrEmpty()) emptyList() else list
    }

    fun findPrincipalsByTitleId(id: Int) = principalsRepository.findById(id)

    fun findRatingByTitleId(id: Int) = ratingRepository.findById(id)

    fun findPersonByNameAndProfession(name: String, profession: String?) =
        nameRepository.findPerson(name, profession)
}