package com.xtremepixel.moviescleanarchitecture.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.xtremepixel.moviescleanarchitecture.domain.models.MovieItem
import com.xtremepixel.moviescleanarchitecture.domain.models.PeopleItem
import com.xtremepixel.moviescleanarchitecture.domain.models.TvShowItem

@Database(entities = [MovieItem::class, TvShowItem::class, PeopleItem::class], version = 1, exportSchema = false)
abstract class MoviesDB: RoomDatabase() {

    abstract fun movieDao(): MoviesDAO
    abstract fun tvShowDao(): TvShowsDAO
    abstract fun artistsDao(): ArtistsDAO
}