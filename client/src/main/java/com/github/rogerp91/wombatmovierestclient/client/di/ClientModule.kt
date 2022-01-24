package com.github.rogerp91.wombatmovierestclient.client.di

import com.github.rogerp91.wombatmovierestclient.client.services.MoviesService
import com.github.rogerp91.wombatmovierestclient.client.services.top_rated.MovieTopRatedClient
import com.github.rogerp91.wombatmovierestclient.client.services.top_rated.MovieTopRatedClientDefault
import com.github.rogerp91.wombatmovierestclient.client.services.top_rated.TopRateInterpreter
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ClientModule {

    @Singleton
    @Provides
    fun provideMovieTopRatedClient(
        services: MoviesService,
        interpreter: TopRateInterpreter
    ): MovieTopRatedClient {
        return MovieTopRatedClientDefault(services, interpreter)
    }
}
