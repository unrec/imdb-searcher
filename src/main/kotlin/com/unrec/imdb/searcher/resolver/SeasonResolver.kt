package com.unrec.imdb.searcher.resolver

import com.unrec.imdb.searcher.model.Season
import com.unrec.imdb.searcher.repository.DatabaseService
import graphql.kickstart.tools.GraphQLResolver
import org.springframework.stereotype.Component

@Component
class SeasonResolver(val databaseService: DatabaseService) : GraphQLResolver<Season> {
    fun episodes(season: Season) = databaseService.findEpisodes(season.parentId!!, season.season!!)
}
