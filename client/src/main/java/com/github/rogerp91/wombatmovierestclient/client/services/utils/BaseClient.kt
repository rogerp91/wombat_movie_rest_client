package com.github.rogerp91.wombatmovierestclient.client.services.utils

import retrofit2.Response

abstract class BaseClient {

    suspend fun <T> safeApiCall(apiCall: suspend () -> Response<T>): NetworkResult<T> {
        try {
            val response = apiCall()
            if (response.isSuccessful) {
                val body = response.body()
                body?.let {
                    return NetworkResult.Success(body)
                }
            }
            return NetworkResult.Error("${response.code()} ${response.message()}")
        } catch (e: Exception) {
            return NetworkResult.Failure(e.message ?: e.toString())
        }
    }
}
