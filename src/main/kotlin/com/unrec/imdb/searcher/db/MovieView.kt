package com.unrec.imdb.searcher.db

import org.jetbrains.exposed.sql.Table

object MovieView : Table("movies_view") {
    val id = integer("title_id")
    val type = varchar("title_type", 64)
    val title = varchar("primary_title", 512)
    val year = short("start_year")
    val runtime = integer("runtime_minutes")
    val directors = text("directors")
    val writers = text("writers")
    val genres = varchar("genres", 128)
    val rating = float("average_rating")
    val votes = integer("num_votes")
}