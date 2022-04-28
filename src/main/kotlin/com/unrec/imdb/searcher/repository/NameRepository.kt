package com.unrec.imdb.searcher.repository

import com.unrec.imdb.searcher.model.Name
import org.springframework.data.jpa.repository.JpaRepository

interface NameRepository : JpaRepository<Name, Int>