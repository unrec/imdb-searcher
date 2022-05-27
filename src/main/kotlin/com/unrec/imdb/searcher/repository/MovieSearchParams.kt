package com.unrec.imdb.searcher.repository

data class MovieSearchParams(
    val title: String?,
    val director: String?,
    val writer: String?,
    val genre: String?,
    val minRating: Float?,
    val minVotes: Int?,
    val limit: Int?,
)