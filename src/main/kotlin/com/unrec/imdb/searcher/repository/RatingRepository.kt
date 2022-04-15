package com.unrec.imdb.searcher.repository

import com.unrec.imdb.searcher.model.Rating
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface RatingRepository : JpaRepository<Rating, Int>