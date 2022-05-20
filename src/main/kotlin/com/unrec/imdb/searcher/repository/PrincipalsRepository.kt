package com.unrec.imdb.searcher.repository

import com.unrec.imdb.searcher.db.PrincipalsTable
import com.unrec.imdb.searcher.db.toPrincipal
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.transactions.transaction
import org.springframework.stereotype.Repository

@Repository
class PrincipalsRepository {

    fun findPrincipalsByTitleId(titleId: Int) = transaction {
            PrincipalsTable.select { PrincipalsTable.titleId eq titleId }.map { it.toPrincipal() }

    }
}