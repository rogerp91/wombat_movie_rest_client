package com.github.rogerp91.wombatmovierestclient

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.github.rogerp91.wombatmovierestclient.client.services.utils.NetworkResult
import com.github.rogerp91.wombatmovierestclient.client.services.top_rated.MovieTopRatedClient
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var client: MovieTopRatedClient

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        GlobalScope.launch {
            when (client.getTopRated()) {
                is NetworkResult.Success -> {
                    Log.d("TAG", "1")
                }
                is NetworkResult.Error -> {
                    Log.d("TAG", "2")
                }
                is NetworkResult.Failure -> {
                    Log.d("TAG", "3")
                }
            }
        }
    }
}