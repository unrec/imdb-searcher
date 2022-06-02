package com.unrec.imdb.searcher.resolver

import com.unrec.imdb.searcher.model.Series
import com.unrec.imdb.searcher.repository.DatabaseService
import graphql.kickstart.tools.GraphQLResolver
import org.springframework.stereotype.Component

@Component
class SeriesResolver(val databaseService: DatabaseService) : GraphQLResolver<Series> {

    fun totalEpisodes(series: Series) =
        databaseService.countEpisodesForSeries(series.data!!.titleId)

    fun totalSeasons(series: Series) =
        databaseService.countSeasonsForSeries(series.data!!.titleId)

    fun totalRuntime(series: Series) =
        databaseService.countTotalRuntimeForSeries(series.data!!.titleId)

    fun seasons(series: Series) = databaseService.findSeasonsByTitleId(series.data!!.titleId)
}
