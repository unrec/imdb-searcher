package com.unrec.imdb.searcher.model

data class Principal(
    val titleId: Int,
    val ordering: Short,
    val nameId: Int,
    val category: String,
    val job: String?,
    val characters: List<String>?,
)