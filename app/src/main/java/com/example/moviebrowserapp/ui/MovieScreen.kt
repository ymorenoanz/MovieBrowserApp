package com.example.moviebrowserapp.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.moviebrowserapp.domain.model.Movie
import com.example.moviebrowserapp.ui.states.MoviesUiStates
import com.example.moviebrowserapp.ui.viewmodel.MovieViewModel

@Composable
fun MoviesScreen(
    viewModel: MovieViewModel = hiltViewModel()) {
    val uiState = viewModel.uiState
    when (uiState) {

        is MoviesUiStates.Loading -> {
            LoadingScreen()
        }

        is MoviesUiStates.Success -> {
            MoviesList(uiState.movies)
        }

        is MoviesUiStates.Error -> {
            ErrorScreen(uiState.message)
        }
    }
}

@Composable
fun MoviesList(movies: List<Movie>) {
    LazyColumn {
        items(movies) { movie ->
            MovieItem(movie)
        }
    }
}

@Composable
fun LoadingScreen() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator()
    }
}

@Composable
fun ErrorScreen(message: String) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(text = message)
    }
}