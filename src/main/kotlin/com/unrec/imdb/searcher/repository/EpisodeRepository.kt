package com.unrec.imdb.searcher.repository

import com.unrec.imdb.searcher.model.Episode
import com.unrec.imdb.searcher.model.EpisodeId
import org.springframework.data.jpa.repository.JpaRepository

interface EpisodeRepository : JpaRepository<Episode, EpisodeId>