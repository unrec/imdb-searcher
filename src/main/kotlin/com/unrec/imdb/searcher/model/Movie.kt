package com.unrec.imdb.searcher.model

data class Movie(
    val id: Int,
    val type: String,
    val title: String,
    val year: Short?,
    val runtime: Int?,
    val directors: String?,
    val writers: String?,
    val genres: String?,
    val rating: Float?,
    val votes: Int?,
)
