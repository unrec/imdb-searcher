package com.unrec.imdb.searcher.repository

import com.unrec.imdb.searcher.model.Aka
import com.unrec.imdb.searcher.model.AkaId
import org.springframework.data.jpa.repository.JpaRepository

interface AkaRepository : JpaRepository<Aka, AkaId>