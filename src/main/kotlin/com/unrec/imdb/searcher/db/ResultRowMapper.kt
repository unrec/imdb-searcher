package com.unrec.imdb.searcher.db

import com.unrec.imdb.searcher.model.Basic
import com.unrec.imdb.searcher.model.Person
import com.unrec.imdb.searcher.model.Rating
import org.jetbrains.exposed.sql.ResultRow

fun ResultRow.toBasic() = Basic(
    titleId = this[BasicTable.titleId],
    titleType = this[BasicTable.titleType],
    primaryTitle = this[BasicTable.primaryTitle],
    originalTitle = this[BasicTable.originalTitle],
    isAdult = this[BasicTable.isAdult],
    startYear = this[BasicTable.startYear],
    endYear = this[BasicTable.endYear],
    runtimeMinutes = this[BasicTable.runtimeMinutes],
    genres = this[BasicTable.genres]
)

fun ResultRow.toRating() = Rating(
    titleId = this[RatingTable.titleId],
    averageRating = this[RatingTable.averageRating],
    numVotes = this[RatingTable.numVotes],
)

fun ResultRow.toPerson() = Person(
    nameId = this[NameBasicsTable.nameId],
    primaryName = this[NameBasicsTable.primaryName],
    birthYear = this[NameBasicsTable.birthYear],
    deathYear = this[NameBasicsTable.deathYear],
    primaryProfession = this[NameBasicsTable.primaryProfession],
    knownForTitles = this[NameBasicsTable.knownForTitles]
)