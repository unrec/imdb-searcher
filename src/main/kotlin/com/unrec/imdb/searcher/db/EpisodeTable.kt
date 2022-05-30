package com.unrec.imdb.searcher.db

import org.jetbrains.exposed.sql.Table

object EpisodeTable : Table("episodes") {
    val titleId = integer("title_id")
    val parentId = integer("parent_id")
    val season = short("season_number")
    val episode = integer("episode_number")
}