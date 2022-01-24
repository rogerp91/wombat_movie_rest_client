package com.github.rogerp91.wombatmovierestclient.client.services.movie.discover

import com.github.rogerp91.wombatmovierestclient.client.model.MovieDTO
import com.github.rogerp91.wombatmovierestclient.client.services.movie.MoviesService
import com.github.rogerp91.wombatmovierestclient.client.services.movie.top_rated.MovieTopRatedClient
import com.github.rogerp91.wombatmovierestclient.client.services.utils.TopRateInterpreter
import com.github.rogerp91.wombatmovierestclient.client.services.utils.BaseClient
import com.github.rogerp91.wombatmovierestclient.client.services.utils.NetworkResult
import javax.inject.Inject

interface DiscoverClient {

    suspend fun getDiscover(): NetworkResult<List<MovieDTO>>
}

class DiscoverClientDefault @Inject constructor(
    private val services: MoviesService,
    private val interpreter: TopRateInterpreter
) : DiscoverClient, BaseClient() {

    override suspend fun getDiscover(): NetworkResult<List<MovieDTO>> {
        var listMovie: List<MovieDTO> = emptyList()
        val result = safeApiCall { services.getTopRated() }
        if (result is NetworkResult.Success) {
            listMovie = interpreter.interpret(result.data)
        }
        return NetworkResult.Success(listMovie)
    }
}