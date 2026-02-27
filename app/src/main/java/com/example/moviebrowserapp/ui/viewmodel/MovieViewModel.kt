package com.example.moviebrowserapp.ui.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviebrowserapp.domain.model.Movie
import com.example.moviebrowserapp.domain.repository.MovieRepository
import com.example.moviebrowserapp.ui.states.MoviesUiStates
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieViewModel @Inject constructor(
    private val repo: MovieRepository
): ViewModel() {

    var uiState by mutableStateOf<MoviesUiStates>(MoviesUiStates.Loading)
        private set

    init {
        loadMovies()
    }

    private fun loadMovies() {
        viewModelScope.launch {
            try {
              val movies = repo.getPopularMovies()
                uiState = MoviesUiStates.Success(movies)
            } catch (e: Exception) {
                uiState = MoviesUiStates.Error(e.message ?: "Unknown error")
                e.printStackTrace()
            }
        }
    }

}