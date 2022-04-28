package com.unrec.imdb.searcher

import com.unrec.imdb.searcher.model.Aka

object TestDataFactory {

    fun testAkaEntity(): Aka = Aka(
        titleId = 110912,
        ordering = 6,
        title = "Криминальное чтиво",
        region = "RU",
        language = null,
        types = "imdbDisplay",
        attributes = null,
        isOriginalTitle = false
    )
}