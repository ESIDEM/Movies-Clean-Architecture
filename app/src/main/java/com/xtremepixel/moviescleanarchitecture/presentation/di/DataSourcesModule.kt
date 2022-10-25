package com.xtremepixel.moviescleanarchitecture.presentation.di

import com.xtremepixel.moviescleanarchitecture.BuildConfig
import com.xtremepixel.moviescleanarchitecture.data.api.MoviesService
import com.xtremepixel.moviescleanarchitecture.data.datasources.*
import com.xtremepixel.moviescleanarchitecture.data.db.ArtistsDAO
import com.xtremepixel.moviescleanarchitecture.data.db.MoviesDAO
import com.xtremepixel.moviescleanarchitecture.data.db.TvShowsDAO
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataSourcesModule {

    @Singleton
    @Provides
    fun provideRemoteDataSource(
        moviesService: MoviesService
    ): RemoteDataSource = RemoteDataSourceImpl(moviesService, BuildConfig.API_KEY)

    @Singleton
    @Provides
    fun provideLocalDataSource(
        moviesDAO: MoviesDAO,
        tvShowsDAO: TvShowsDAO,
        artistsDAO: ArtistsDAO
    ): LocalDataSource =
        LocalDataSourceImpl(moviesDAO = moviesDAO, tvShowsDAO = tvShowsDAO, artistsDAO = artistsDAO)

    @Singleton
    @Provides
    fun provideCacheDataSource(): CachedDataSource = CacheDataSourceImpl()
}