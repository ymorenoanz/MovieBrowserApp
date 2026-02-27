package com.example.moviebrowserapp.data.repository

import com.example.moviebrowserapp.BuildConfig
import com.example.moviebrowserapp.BuildConfig.API_KEY
import com.example.moviebrowserapp.data.network.MovieApiService
import com.example.moviebrowserapp.domain.model.Movie
import com.example.moviebrowserapp.domain.repository.MovieRepository
import com.example.moviebrowserapp.data.mapper.toDomain
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val api: MovieApiService
) : MovieRepository {

    override suspend fun getPopularMovies(): List<Movie> {
        return api.getPopularMovies(API_KEY).results.map { it.toDomain() }
    }
}




