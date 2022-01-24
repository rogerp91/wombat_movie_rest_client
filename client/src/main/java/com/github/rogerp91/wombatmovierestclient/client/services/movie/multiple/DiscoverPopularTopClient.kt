package com.github.rogerp91.wombatmovierestclient.client.services.movie.multiple

import com.github.rogerp91.wombatmovierestclient.client.model.DiscoverPopularTopDTO
import com.github.rogerp91.wombatmovierestclient.client.model.MovieDTO
import com.github.rogerp91.wombatmovierestclient.client.services.movie.MoviesService
import com.github.rogerp91.wombatmovierestclient.client.services.utils.BaseClient
import com.github.rogerp91.wombatmovierestclient.client.services.utils.NetworkResult
import com.github.rogerp91.wombatmovierestclient.client.services.utils.TopRateInterpreter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.withContext
import javax.inject.Inject

interface DiscoverPopularTopClient {

    suspend fun getDiscoverPopularTop(): NetworkResult<DiscoverPopularTopDTO>
}

class DiscoverPopularTopDefault @Inject constructor(
    private val services: MoviesService,
    private val interpreter: TopRateInterpreter
) : DiscoverPopularTopClient, BaseClient() {

    override suspend fun getDiscoverPopularTop(): NetworkResult<DiscoverPopularTopDTO> {
        var listDiscover = emptyList<MovieDTO>()
        var listPopular = emptyList<MovieDTO>()
        var listTop = emptyList<MovieDTO>()

        withContext(Dispatchers.IO) {
            val call1 = async { safeApiCall { services.getDiscover() } }
            val call2 = async { safeApiCall { services.getPopular() } }
            val call3 = async { safeApiCall { services.getTopRated() } }

            try {
                val response = call1.await()
                val response2 = call2.await()
                val response3 = call3.await()

                if (response is NetworkResult.Success) {
                    listDiscover = interpreter.interpret(response.data)
                }

                if (response2 is NetworkResult.Success) {
                    listPopular = interpreter.interpret(response2.data)
                }

                if (response3 is NetworkResult.Success) {
                    listTop = interpreter.interpret(response3.data)
                }
            } catch (ex: Exception) {
                ex.printStackTrace()
            }
        }

        val result = DiscoverPopularTopDTO(listTop, listDiscover, listPopular)
        return NetworkResult.Success(result)
    }
}
