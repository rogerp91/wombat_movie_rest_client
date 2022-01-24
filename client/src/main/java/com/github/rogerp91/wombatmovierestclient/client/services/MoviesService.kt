package com.github.rogerp91.wombatmovierestclient.client.services

import com.github.rogerp91.wombatmovierestclient.client.model.DataDTO
import retrofit2.Response
import retrofit2.http.GET

interface MoviesService {

    @GET("movie/top_rated")
    suspend fun getTopRated(): Response<DataDTO>
}
