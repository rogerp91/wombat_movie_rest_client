package com.github.rogerp91.wombatmovierestclient.client.services.tv

import com.github.rogerp91.wombatmovierestclient.client.model.DataDTO
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface TvService {

    @GET("tv/top_rated")
    suspend fun getTopRated(): Response<DataDTO>

    @GET("discover/tv")
    suspend fun getDiscover(): Response<DataDTO>

    @GET("tv/popular")
    suspend fun getPopular(): Response<DataDTO>

    @GET("tv/{id}")
    suspend fun getTvForId(@Path("id") id: String): Response<DataDTO>
}