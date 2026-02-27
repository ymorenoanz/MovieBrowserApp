package com.example.moviebrowserapp.ui.states

import com.example.moviebrowserapp.domain.model.Movie

sealed class MoviesUiStates {
    object Loading : MoviesUiStates()
    data class Success(val movies: List<Movie>) : MoviesUiStates()
    data class Error(val message: String) : MoviesUiStates()
}