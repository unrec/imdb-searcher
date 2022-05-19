package com.unrec.imdb.searcher.db

import org.jetbrains.exposed.sql.Table

object NameBasicsTable : Table("name_basics") {
    val nameId = integer("name_id")
    val primaryName = varchar("primary_name", 128)
    val birthYear = short("birth_year")
    val deathYear = short("death_year")
    val primaryProfession = text("primary_profession")
    val knownForTitles = text("known_for_titles")

    override val primaryKey = PrimaryKey(nameId, name = "name_basics_pkey")

}