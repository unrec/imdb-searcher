package com.unrec.imdb.searcher.model

data class Episode(
    val titleId: Int,
    val parentId: Int,
    val season: Short,
    val episode: Int,
)
