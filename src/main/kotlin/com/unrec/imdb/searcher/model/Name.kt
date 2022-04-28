package com.unrec.imdb.searcher.model

import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "name_basics")
class Name(
    @Id
    val nameId: Int,
    val primaryName: String,
    val birthYear: Int?,
    val deathYear: Int?,
    val primaryProfession: String?,
    val knownForTitles: String?,
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Name

        if (nameId != other.nameId) return false

        return true
    }

    override fun hashCode(): Int {
        return nameId
    }
}