package com.github.rogerp91.wombatmovierestclient

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.github.rogerp91.wombatmovierestclient.client.services.movie.discover.DiscoverClient
import com.github.rogerp91.wombatmovierestclient.client.services.movie.id.MoviesForIdClient
import com.github.rogerp91.wombatmovierestclient.client.services.movie.multiple.DiscoverPopularTopClient
import com.github.rogerp91.wombatmovierestclient.client.services.movie.popular.PopularClient
import com.github.rogerp91.wombatmovierestclient.client.services.utils.NetworkResult
import com.github.rogerp91.wombatmovierestclient.client.services.movie.top_rated.MovieTopRatedClient
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var movieTopRatedClient: MovieTopRatedClient

    @Inject
    lateinit var discoverClient: DiscoverClient

    @Inject
    lateinit var popularClient: PopularClient

    @Inject
    lateinit var moviesForIdClient: MoviesForIdClient

    @Inject
    lateinit var discoverPopularTopClient: DiscoverPopularTopClient

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /**
         * getTopRated
         */
        GlobalScope.launch {
            when (movieTopRatedClient.getTopRated()) {
                is NetworkResult.Success -> {
                    Log.d("getTopRated", "1")
                }
                is NetworkResult.Error -> {
                    Log.d("getTopRated", "2")
                }
                is NetworkResult.Failure -> {
                    Log.d("getTopRated", "3")
                }
            }
        }

        /**
         * getDiscover
         */
        GlobalScope.launch {
            when (discoverClient.getDiscover()) {
                is NetworkResult.Success -> {
                    Log.d("getDiscover", "1")
                }
                is NetworkResult.Error -> {
                    Log.d("getDiscover", "2")
                }
                is NetworkResult.Failure -> {
                    Log.d("getDiscover", "3")
                }
            }
        }

        /**
         * getPopular
         */
        GlobalScope.launch {
            when (popularClient.getPopular()) {
                is NetworkResult.Success -> {
                    Log.d("getPopular", "1")
                }
                is NetworkResult.Error -> {
                    Log.d("getPopular", "2")
                }
                is NetworkResult.Failure -> {
                    Log.d("getPopular", "3")
                }
            }
        }

        /**
         * getForId
         */
        GlobalScope.launch {
            when (moviesForIdClient.getForId("157336")) {
                is NetworkResult.Success -> {
                    Log.d("getForId", "1")
                }
                is NetworkResult.Error -> {
                    Log.d("getForId", "2")
                }
                is NetworkResult.Failure -> {
                    Log.d("getForId", "3")
                }
            }
        }

        /**
         *
         */
        GlobalScope.launch {
            when (discoverPopularTopClient.getDiscoverPopularTop()) {
                is NetworkResult.Success -> {
                    Log.d("getDiscoverPopularTop", "1")
                }
                is NetworkResult.Error -> {
                    Log.d("getDiscoverPopularTop", "2")
                }
                is NetworkResult.Failure -> {
                    Log.d("getDiscoverPopularTop", "3")
                }
            }
        }
    }
}