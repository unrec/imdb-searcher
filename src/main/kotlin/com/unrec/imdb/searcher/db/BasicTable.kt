package com.unrec.imdb.searcher.db

import org.jetbrains.exposed.sql.Table

object BasicTable : Table("basics") {
    val titleId = integer("title_id")
    val titleType = varchar("title_type", 64)
    val primaryTitle = varchar("primary_title", 512)
    val originalTitle = varchar("original_title", 512)
    val isAdult = bool("is_adult")
    val startYear = short("start_year")
    val endYear = short("end_year")
    val runtimeMinutes = integer("runtime_minutes")
    val genres = varchar("genres", 128)

    override val primaryKey = PrimaryKey(titleId, name = "basics_pkey")
}
