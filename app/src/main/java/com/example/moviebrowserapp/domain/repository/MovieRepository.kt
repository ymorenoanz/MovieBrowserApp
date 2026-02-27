package com.example.moviebrowserapp.domain.repository

import com.example.moviebrowserapp.domain.model.Movie

interface MovieRepository {
    suspend fun getPopularMovies(): List<Movie>
}