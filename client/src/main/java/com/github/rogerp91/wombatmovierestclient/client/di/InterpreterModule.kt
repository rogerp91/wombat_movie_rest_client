package com.github.rogerp91.wombatmovierestclient.client.di

import com.github.rogerp91.wombatmovierestclient.client.services.utils.TopRateInterpreter
import com.github.rogerp91.wombatmovierestclient.client.services.utils.TopRateInterpreterDefault
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object InterpreterModule {

    @Singleton
    @Provides
    fun providerTopRateInterpreter(): TopRateInterpreter {
        return TopRateInterpreterDefault()
    }
}
