package com.unrec.imdb.searcher.repository

import com.unrec.imdb.searcher.model.Basic
import com.unrec.imdb.searcher.model.Episode
import com.unrec.imdb.searcher.model.Person
import org.jetbrains.exposed.sql.Column
import org.springframework.stereotype.Service

@Service
class DatabaseService(
    private val basicRepository: BasicRepository,
    private val episodeRepository: EpisodeRepository,
    private val crewRepository: CrewRepository,
    private val nameRepository: NameRepository,
    private val principalsRepository: PrincipalsRepository,
    private val ratingRepository: RatingRepository,
    private val movieViewRepository: MovieViewRepository,
) {
    fun findMovieByTitleId(id: Int) = basicRepository.findById(id)

    fun findSeriesByTitleId(id: Int) = basicRepository.findSeriesById(id)

    fun findEpisodeByTitleId(id: Int) = episodeRepository.findById(id)

    fun countEpisodesForSeries(titleId: Int) = episodeRepository.countEpisodesForParentId(titleId)

    fun countSeasonsForSeries(titleId: Int) = episodeRepository.countSeasonsForParentId(titleId)

    fun countTotalRuntimeForSeries(titleId: Int): Int {
        val episodesIds = episodeRepository.findEpisodesIdByParentId(titleId)
        return basicRepository.countTotalRuntimeForIds(episodesIds)
    }

    fun findSeasonsByTitleId(titleId: Int) = episodeRepository.findSeasonsByTitleId(titleId)

    fun findEpisodes(parentId: Int, season: Short): List<Episode> =
        episodeRepository.findEpisodes(parentId, season)

    fun findSeriesByEpisode(episode: Episode) = basicRepository.findById(episode.parentId)

    fun findCrew(basic: Basic, column: Column<String>): List<Person> {
        val ids = crewRepository.findCrewByTitleId(basic.titleId, column)
        if (ids.isNullOrEmpty()) return emptyList()

        val list = nameRepository.findByIds(ids)
        return if (list.isNullOrEmpty()) emptyList() else list
    }

    fun findPrincipalsByTitleId(id: Int) = principalsRepository.findById(id)

    fun findRatingByTitleId(id: Int) = ratingRepository.findById(id)

    fun findPersonByNameAndProfession(name: String, profession: String?) =
        nameRepository.findPerson(name, profession)

    fun findMoviesByParams(params: MovieSearchParams) = movieViewRepository.findByParams(params)

}
