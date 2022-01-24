package com.github.rogerp91.wombatmovierestclient.client.model

data class DataDTO(
    val page: Int,
    val results: List<ResultDTO>,
    val totalPages: Int,
    val totalResults: Int
)
