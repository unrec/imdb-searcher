package com.unrec.imdb.searcher.repository

import com.unrec.imdb.searcher.model.Principal
import com.unrec.imdb.searcher.model.PrincipalId
import org.springframework.data.jpa.repository.JpaRepository

interface PrincipalRepository : JpaRepository<Principal, PrincipalId>