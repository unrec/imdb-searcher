package com.unrec.imdb.searcher.repository

import com.unrec.imdb.searcher.db.BasicTable
import com.unrec.imdb.searcher.db.toBasic
import com.unrec.imdb.searcher.model.Basic
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.transactions.transaction
import org.springframework.stereotype.Repository

@Repository
class BasicRepository {

    fun findMovieById(id: Int) = transaction {
        BasicTable.select { BasicTable.titleId eq id }.firstOrNull()?.toBasic()
    }

    fun findMovies(ids: String?): List<Basic>? = transaction {
        val idList = ids?.split(",")?.map { it.toInt() }
        return@transaction if (idList.isNullOrEmpty()) emptyList()
        else BasicTable.select { BasicTable.titleId inList idList }.map { it.toBasic() }
    }
}
