package com.xtremepixel.moviescleanarchitecture.presentation.di

import android.content.Context
import androidx.room.Room
import com.xtremepixel.moviescleanarchitecture.data.db.ArtistsDAO
import com.xtremepixel.moviescleanarchitecture.data.db.MoviesDAO
import com.xtremepixel.moviescleanarchitecture.data.db.MoviesDB
import com.xtremepixel.moviescleanarchitecture.data.db.TvShowsDAO
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(context: Context): MoviesDB =
        Room.databaseBuilder(context, MoviesDB::class.java, "movieDb").build()

    @Singleton
    @Provides
    fun provideMoviesDao(moviesDB: MoviesDB): MoviesDAO = moviesDB.movieDao()

    @Singleton
    @Provides
    fun provideTvShowsDao(moviesDB: MoviesDB): TvShowsDAO = moviesDB.tvShowDao()

    @Singleton
    @Provides
    fun provideArtistDao(moviesDB: MoviesDB): ArtistsDAO = moviesDB.artistsDao()
}