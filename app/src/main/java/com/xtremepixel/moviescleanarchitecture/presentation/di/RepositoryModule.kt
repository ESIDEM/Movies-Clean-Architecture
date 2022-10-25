package com.xtremepixel.moviescleanarchitecture.presentation.di

import com.xtremepixel.moviescleanarchitecture.data.datasources.CachedDataSource
import com.xtremepixel.moviescleanarchitecture.data.datasources.LocalDataSource
import com.xtremepixel.moviescleanarchitecture.data.datasources.RemoteDataSource
import com.xtremepixel.moviescleanarchitecture.data.repository.MovieRepositoryImpl
import com.xtremepixel.moviescleanarchitecture.domain.repository.MoviesRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Singleton
    @Provides
    fun provideRepository(
         remoteDataSource: RemoteDataSource,
         cachedDataSource: CachedDataSource,
         localDataSource: LocalDataSource
    ): MoviesRepository = MovieRepositoryImpl(remoteDataSource, cachedDataSource, localDataSource)
}