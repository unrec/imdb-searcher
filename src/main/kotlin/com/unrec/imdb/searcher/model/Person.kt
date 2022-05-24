package com.unrec.imdb.searcher.model

data class Person(
    val nameId: Int,
    val primaryName: String,
    val birthYear: Short?,
    val deathYear: Short?,
    val primaryProfession: String?,
    val knownForTitles: String?,
)