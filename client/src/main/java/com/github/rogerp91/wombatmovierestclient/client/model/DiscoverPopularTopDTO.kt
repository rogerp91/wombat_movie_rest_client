package com.github.rogerp91.wombatmovierestclient.client.model

data class DiscoverPopularTopDTO(
    val topRated: List<MovieDTO>,
    val discover: List<MovieDTO>,
    val popular: List<MovieDTO>,
)
