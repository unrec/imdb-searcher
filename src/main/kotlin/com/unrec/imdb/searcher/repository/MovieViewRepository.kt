package com.unrec.imdb.searcher.repository

import com.unrec.imdb.searcher.db.MovieView
import com.unrec.imdb.searcher.db.MovieView.directors
import com.unrec.imdb.searcher.db.MovieView.genres
import com.unrec.imdb.searcher.db.MovieView.rating
import com.unrec.imdb.searcher.db.MovieView.title
import com.unrec.imdb.searcher.db.MovieView.votes
import com.unrec.imdb.searcher.db.MovieView.writers
import com.unrec.imdb.searcher.db.toMovie
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.SortOrder.DESC
import org.jetbrains.exposed.sql.transactions.transaction
import org.springframework.stereotype.Repository

const val defaultLimit = 50

@Repository
class MovieViewRepository {

    fun findByParams(params: MovieSearchParams) = transaction {
        val limit = params.limit ?: defaultLimit
        val query = MovieView.selectAll().limit(limit).orderBy(rating, DESC)

        params.title?.let { addLikeFilter(query, title, params.title) }
        params.director?.let { addLikeFilter(query, directors, params.director) }
        params.writer?.let { addLikeFilter(query, writers, params.writer) }
        params.genre?.let { addLikeFilter(query, genres, params.genre) }
        params.minRating?.let { query.andWhere { rating.greater(params.minRating) } }
        params.minVotes?.let { query.andWhere { votes.greater(params.minVotes) } }
        query.map { it.toMovie() }
    }

    private fun addLikeFilter(query: Query, column: Column<String>, parameter: String) {
        query.andWhere { column.lowerCase().like("%${parameter.lowercase()}%") }
    }

}
