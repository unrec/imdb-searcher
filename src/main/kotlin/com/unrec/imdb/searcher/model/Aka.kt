package com.unrec.imdb.searcher.model

import java.io.Serializable
import javax.persistence.*

@Entity
@IdClass(AkaId::class)
@Table(name = "akas")
data class Aka(
    @Id
    val titleId: Int,
    @Id
    val ordering: Int,

    val title: String,
    val region: String,
    val language: String?,
    val types: String?,
    val attributes: String?,
    val isOriginalTitle: Boolean?,
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Aka

        if (titleId != other.titleId) return false

        return true
    }

    override fun hashCode(): Int {
        return titleId.hashCode()
    }
}

data class AkaId(val titleId: Int = 0, val ordering: Int = 0) : Serializable