package com.unrec.imdb.searcher.db

import com.unrec.imdb.searcher.model.*
import org.jetbrains.exposed.sql.Column
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

fun ResultRow.toMovie() = Movie(
    id = this[MovieView.id],
    type = this[MovieView.type],
    title = this[MovieView.title],
    year = this[MovieView.year],
    runtime = this[MovieView.runtime],
    directors = this[MovieView.directors],
    writers = this[MovieView.writers],
    genres = this[MovieView.genres],
    rating = this[MovieView.rating],
    votes = this[MovieView.votes],
    )

 fun ResultRow.toEpisode() = Episode(
     titleId = this[EpisodeTable.titleId],
     parentId = this[EpisodeTable.parentId],
     season = this[EpisodeTable.season],
     episode = this[EpisodeTable.episode]
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

fun ResultRow.toPrincipal() = Principal(
    titleId = this[PrincipalsTable.titleId],
    ordering = this[PrincipalsTable.ordering],
    nameId = this[PrincipalsTable.nameId],
    category = this[PrincipalsTable.category],
    job = this[PrincipalsTable.job],
    characters = extractCharacters(this, PrincipalsTable.characters)
)

private fun extractCharacters(resultRow: ResultRow, column: Column<String?>): List<String>? {
    return resultRow[column]?.removeTrailingSymbols()?.split(",")?.map {
        it.removeTrailingSymbols()
    }
}

private fun String.removeTrailingSymbols() = this.substring(1, this.length - 1)
