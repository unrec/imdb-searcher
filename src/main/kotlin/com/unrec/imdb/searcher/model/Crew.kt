package com.unrec.imdb.searcher.model

import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "crew")
class Crew(
    @Id
    val titleId: Int,
    val directors: String?,
    val writers: String?,
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Crew

        if (titleId != other.titleId) return false

        return true
    }

    override fun hashCode(): Int {
        return titleId
    }
}
