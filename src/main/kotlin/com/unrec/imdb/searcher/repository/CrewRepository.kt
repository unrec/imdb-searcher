package com.unrec.imdb.searcher.repository

import com.unrec.imdb.searcher.model.Crew
import org.springframework.data.jpa.repository.JpaRepository

interface CrewRepository : JpaRepository<Crew, Long>