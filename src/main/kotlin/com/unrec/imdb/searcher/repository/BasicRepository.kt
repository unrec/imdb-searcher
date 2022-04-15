package com.unrec.imdb.searcher.repository

import com.unrec.imdb.searcher.model.Basic
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface BasicRepository : JpaRepository<Basic, Int>