package com.unrec.imdb.searcher.repository

import com.unrec.imdb.searcher.db.BasicTable
import com.unrec.imdb.searcher.db.BasicTable.runtimeMinutes
import com.unrec.imdb.searcher.db.BasicTable.titleId
import com.unrec.imdb.searcher.db.toBasic
import com.unrec.imdb.searcher.exception.WrongTypeException
import com.unrec.imdb.searcher.model.Basic
import com.unrec.imdb.searcher.model.Element.TV_SERIES
import com.unrec.imdb.searcher.model.Series
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.transactions.transaction
import org.springframework.stereotype.Repository

@Repository
class BasicRepository {

    fun findById(id: Int) = transaction {
        BasicTable.select { titleId eq id }.firstOrNull()?.toBasic()
    }

    fun findMovies(ids: String?): List<Basic>? = transaction {
        val idList = ids?.toIntList()
        return@transaction if (idList.isNullOrEmpty()) emptyList()
        else BasicTable.select { titleId inList idList }.map { it.toBasic() }
    }

    fun findSeriesById(id: Int): Series? = transaction {
        val basic = BasicTable.select { titleId eq id }
            .firstOrNull()?.toBasic() ?: return@transaction null

        if (basic.titleType != tvSeries) throw WrongTypeException(TV_SERIES, id)
        return@transaction Series(data = basic)
    }

    fun countTotalRuntimeForIds(episodesIds: List<Int>) = transaction {
        BasicTable.slice(runtimeMinutes)
            .select { titleId inList episodesIds }
            .sumOf { it[runtimeMinutes] }
    }
}
