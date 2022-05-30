package com.unrec.imdb.searcher.resolver

import com.unrec.imdb.searcher.model.Episode
import com.unrec.imdb.searcher.repository.DatabaseService
import graphql.kickstart.tools.GraphQLResolver
import org.springframework.stereotype.Component

@Component
class EpisodeResolver(val databaseService: DatabaseService) : GraphQLResolver<Episode> {

    fun data(episode: Episode) = databaseService.findMovieByTitleId(episode.titleId)
    fun parent(episode: Episode) = databaseService.findSeriesByEpisode(episode)

}
