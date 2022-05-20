package com.unrec.imdb.searcher.db

import org.jetbrains.exposed.sql.Table

object PrincipalsTable : Table("principals") {
    val titleId = integer("title_id")
    val ordering = short("ordering")
    val nameId = integer("name_id")
    val category = varchar("category", 64)
    val job = text("job")
    val characters = text("characters").nullable()
}