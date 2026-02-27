package com.example.moviebrowserapp.data.network

import com.example.moviebrowserapp.BuildConfig
import com.example.moviebrowserapp.data.model.MovieResponseDto
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApiService {
        @GET("movie/popular")
        suspend fun getPopularMovies(
            @Query("api_key") apiKey: String = BuildConfig.API_KEY
        ): MovieResponseDto
}