package com.unrec.imdb.searcher.repository

import com.unrec.imdb.searcher.db.RatingTable
import com.unrec.imdb.searcher.db.toRating
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.transactions.transaction
import org.springframework.stereotype.Repository

@Repository
class RatingRepository {

    fun findById(id: Int) = transaction {
        RatingTable.select { RatingTable.titleId eq id }.firstOrNull()?.toRating()
    }

}
