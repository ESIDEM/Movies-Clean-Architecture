package com.xtremepixel.moviescleanarchitecture.presentation.di

import com.xtremepixel.moviescleanarchitecture.domain.repository.MoviesRepository
import com.xtremepixel.moviescleanarchitecture.domain.usecase.*
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class UseCaseModule {

    @Singleton
    @Provides
    fun provideGetMovieUseCase(moviesRepository: MoviesRepository):
            GetMoviesUseCase = GetMoviesUseCase(moviesRepository = moviesRepository)

    @Singleton
    @Provides
    fun provideUpdateMovieUseCase(moviesRepository: MoviesRepository):
            UpdateMoviesUseCase = UpdateMoviesUseCase(moviesRepository = moviesRepository)

    @Singleton
    @Provides
    fun provideGetTvShowsUseCase(moviesRepository: MoviesRepository):
            GetTvShowsUseCase = GetTvShowsUseCase(moviesRepository = moviesRepository)

    @Singleton
    @Provides
    fun provideUpdateTvShowsUseCase(moviesRepository: MoviesRepository):
            UpdateTvShowsUseCase = UpdateTvShowsUseCase(moviesRepository = moviesRepository)

    @Singleton
    @Provides
    fun provideGetArtistUseCase(moviesRepository: MoviesRepository):
            GetArtistsUseCase = GetArtistsUseCase(moviesRepository = moviesRepository)

    @Singleton
    @Provides
    fun provideUpdateArtistsUseCase(moviesRepository: MoviesRepository):
            UpdateArtistsUseCase = UpdateArtistsUseCase(moviesRepository = moviesRepository)
}