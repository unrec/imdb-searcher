package com.unrec.imdb.searcher.db

import org.jetbrains.exposed.sql.Table

object RatingTable : Table("ratings") {
    val titleId = integer("title_id")
    val averageRating = float("average_rating")
    val numVotes = integer("num_votes")

    override val primaryKey = PrimaryKey(titleId, name = "ratings_pkey")
}
