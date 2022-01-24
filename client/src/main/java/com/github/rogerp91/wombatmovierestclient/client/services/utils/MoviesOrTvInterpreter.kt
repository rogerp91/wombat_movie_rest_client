package com.github.rogerp91.wombatmovierestclient.client.services.utils

import com.github.rogerp91.wombatmovierestclient.client.Constants.URL_W500_IMAGE
import com.github.rogerp91.wombatmovierestclient.client.model.DataDTO
import com.github.rogerp91.wombatmovierestclient.client.model.MovieDTO

interface TopRateInterpreter {

    fun interpret(dataDTO: DataDTO?): List<MovieDTO>
}

class TopRateInterpreterDefault : TopRateInterpreter {

    override fun interpret(dataDTO: DataDTO?): List<MovieDTO> {
        val result: MutableList<MovieDTO> = mutableListOf()
        dataDTO?.results?.forEach {
            val movies = MovieDTO(
                it.adult,
                it.backdropPath,
                it.genreIds,
                it.id,
                it.originalLanguage,
                it.originalTitle,
                it.overview,
                it.popularity,
                it.posterPath,
                it.releaseDate,
                it.originalTitle,
                it.video,
                it.voteAverage,
                it.voteCount,
                URL_W500_IMAGE + it.backdropPath
            )
            result.add(movies)
        }

        return result.toList()
    }
}
