package com.github.rogerp91.wombatmovierestclient.client.services.movie.top_rated

import com.github.rogerp91.wombatmovierestclient.client.model.MovieDTO
import com.github.rogerp91.wombatmovierestclient.client.services.movie.MoviesService
import com.github.rogerp91.wombatmovierestclient.client.services.utils.BaseClient
import com.github.rogerp91.wombatmovierestclient.client.services.utils.NetworkResult
import com.github.rogerp91.wombatmovierestclient.client.services.utils.TopRateInterpreter
import javax.inject.Inject

interface MovieTopRatedClient {

    suspend fun getTopRated(): NetworkResult<List<MovieDTO>>
}

class MovieTopRatedClientDefault @Inject constructor(
    private val services: MoviesService,
    private val interpreter: TopRateInterpreter
) : MovieTopRatedClient, BaseClient() {

    override suspend fun getTopRated(): NetworkResult<List<MovieDTO>> {
        var listMovie: List<MovieDTO> = emptyList()
        val result = safeApiCall { services.getTopRated() }
        if (result is NetworkResult.Success) {
            listMovie = interpreter.interpret(result.data)
        }
        return NetworkResult.Success(listMovie)
    }
}
