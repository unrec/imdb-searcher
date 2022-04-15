package com.unrec.imdb.searcher.model

import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "basics")
class Basic(
    @Id
    val titleId: Int,
    val titleType: String,
    val primaryTitle: String,
    val originalTitle: String,
    val isAdult: Boolean?,
    val startYear: Int?,
    val endYear: Int?,
    val runtimeMinutes: Int?,
    val genres: String,
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Basic

        if (titleId != other.titleId) return false

        return true
    }

    override fun hashCode(): Int {
        return titleId.hashCode()
    }
}