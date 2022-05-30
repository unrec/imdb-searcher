package com.unrec.imdb.searcher.repository

import com.unrec.imdb.searcher.db.EpisodeTable
import com.unrec.imdb.searcher.db.toEpisode
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.transactions.transaction
import org.springframework.stereotype.Repository

@Repository
class EpisodeRepository {

    fun findById(id: Int) = transaction {
        EpisodeTable.select { EpisodeTable.titleId eq id }.firstOrNull()?.toEpisode()
    }

}
