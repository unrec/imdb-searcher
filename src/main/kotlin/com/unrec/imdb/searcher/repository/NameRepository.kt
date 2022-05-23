package com.unrec.imdb.searcher.repository

import com.unrec.imdb.searcher.db.NameBasicsTable
import com.unrec.imdb.searcher.db.toPerson
import com.unrec.imdb.searcher.model.Person
import org.jetbrains.exposed.sql.and
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.transactions.transaction
import org.springframework.stereotype.Repository

@Repository
class NameRepository {

    fun findById(id: Int) = transaction {
        NameBasicsTable.select { NameBasicsTable.nameId eq id }.firstOrNull()?.toPerson()
    }

    fun findByIds(ids: List<Int>): List<Person>? = transaction {
        NameBasicsTable.select { NameBasicsTable.nameId inList ids }.map { it.toPerson() }
    }

    fun findPerson(name: String) = transaction {
        NameBasicsTable.select { NameBasicsTable.primaryName eq name }.firstOrNull()?.toPerson()
    }

    fun findPerson(name: String, profession: String?) = transaction {
        when (profession) {
            null -> NameBasicsTable.select { NameBasicsTable.primaryName eq name }
            else -> NameBasicsTable.select {
                (NameBasicsTable.primaryName eq name) and
                        (NameBasicsTable.primaryProfession.like("%$profession%"))
            }
        }.map { it.toPerson() }
    }
}