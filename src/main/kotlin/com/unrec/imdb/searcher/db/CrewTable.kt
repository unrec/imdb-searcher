package com.unrec.imdb.searcher.db

import org.jetbrains.exposed.sql.Table

object CrewTable : Table("crew") {
    val titleId = integer("title_id")
    val directors = text("directors")
    val writers = text("writers")
}