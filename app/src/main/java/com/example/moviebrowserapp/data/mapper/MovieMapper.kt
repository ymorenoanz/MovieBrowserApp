package com.example.moviebrowserapp.data.mapper

import com.example.moviebrowserapp.data.model.MovieDto
import com.example.moviebrowserapp.domain.model.Movie

fun MovieDto.toDomain(): Movie {
    return Movie(
        id = id,
        title = title,
        overview = overview,
        posterPath = posterPath)
}