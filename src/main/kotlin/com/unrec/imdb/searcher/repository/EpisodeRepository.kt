package com.unrec.imdb.searcher.repository

import com.unrec.imdb.searcher.db.EpisodeTable
import com.unrec.imdb.searcher.db.EpisodeTable.parentId
import com.unrec.imdb.searcher.db.EpisodeTable.season
import com.unrec.imdb.searcher.db.EpisodeTable.titleId
import com.unrec.imdb.searcher.db.toEpisode
import org.jetbrains.exposed.sql.max
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.transactions.transaction
import org.springframework.stereotype.Repository

@Repository
class EpisodeRepository {

    fun findById(id: Int) = transaction {
        EpisodeTable.select { titleId eq id }.firstOrNull()?.toEpisode()
    }

    fun countEpisodesForParentId(id: Int) = transaction {
        EpisodeTable.select { parentId eq id }.count().toShort()
    }

    fun countSeasonsForParentId(id: Int) = transaction {
        EpisodeTable.slice(season.max())
            .select { parentId eq id }
            .firstOrNull()?.get(season.max())
    }

    fun findEpisodesIdByParentId(id: Int) = transaction {
        EpisodeTable.slice(titleId)
            .select { parentId eq id }
            .map { it[titleId] }
    }
}
