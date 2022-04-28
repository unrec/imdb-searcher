package com.unrec.imdb.searcher.model

import java.io.Serializable
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.IdClass
import javax.persistence.Table

@Entity
@IdClass(PrincipalId::class)
@Table(name = "principals")
class Principal(
    @Id
    val titleId: Int,
    @Id
    val ordering: Int,

    val nameId: Long,
    val category: String,
    val job: String?,
    val characters: String?,
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Principal

        if (titleId != other.titleId) return false
        if (ordering != other.ordering) return false

        return true
    }

    override fun hashCode(): Int {
        var result = titleId.hashCode()
        result = 31 * result + (ordering ?: 0)
        return result
    }
}

data class PrincipalId(val titleId: Long = 0, val ordering: Int = 0) : Serializable