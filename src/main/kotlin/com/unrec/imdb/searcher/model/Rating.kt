package com.unrec.imdb.searcher.model

data class Rating(
    val titleId: Int,
    val averageRating: Float,
    val numVotes: Int,
)