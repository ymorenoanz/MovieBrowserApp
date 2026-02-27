package com.example.moviebrowserapp.di

import com.example.moviebrowserapp.data.network.MovieApiService
import com.example.moviebrowserapp.data.repository.MovieRepositoryImpl
import com.example.moviebrowserapp.domain.repository.MovieRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    fun provideMoviesRepository(
        api: MovieApiService
    ): MovieRepository {
        return MovieRepositoryImpl(api)
    }
}