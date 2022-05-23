package com.unrec.imdb.searcher.repository

import com.unrec.imdb.searcher.db.CrewTable
import org.jetbrains.exposed.sql.Column
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.transactions.transaction
import org.springframework.stereotype.Repository

@Repository
class CrewRepository {

    fun findCrewByTitleId(titleId: Int, column: Column<String>): List<Int>? = transaction {
        CrewTable
            .slice(column)
            .select { CrewTable.titleId eq titleId }
            .map { it[column] }.firstOrNull()?.toIntList()
    }

    private fun String.toIntList() = this.split(",").map { it.toInt() }

}