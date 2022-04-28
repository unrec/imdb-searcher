package com.unrec.imdb.searcher.model

import java.io.Serializable
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.IdClass
import javax.persistence.Table

@Entity
@IdClass(EpisodeId::class)
@Table(name = "episodes")
class Episode(
    @Id
    val titleId: Int,
    @Id
    val parentId: Int,

    val seasonNumber: Int?,
    val episodeNumber: Int?,
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Episode

        if (titleId != other.titleId) return false
        if (parentId != other.parentId) return false

        return true
    }

    override fun hashCode(): Int {
        var result = titleId
        result = 31 * result + parentId
        return result
    }
}

data class EpisodeId(val titleId: Long = 0, val parentId: Int = 0) : Serializable