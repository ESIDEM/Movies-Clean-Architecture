package com.xtremepixel.moviescleanarchitecture.data.repository

import com.xtremepixel.moviescleanarchitecture.models.MovieItem
import com.xtremepixel.moviescleanarchitecture.models.PeopleItem
import com.xtremepixel.moviescleanarchitecture.models.TvShowItem

interface LocalDataSource {

    suspend fun getMoviesFromDB(): List<MovieItem>

    suspend fun saveMoviesToDb(movies: List<MovieItem>)

    suspend fun clearMovies()

    suspend fun getTvShowsFromDB(): List<TvShowItem>

    suspend fun saveTvShowsToDb(tvShows: List<TvShowItem>)

    suspend fun clearTvShows()

    suspend fun getArtistsFromDB(): List<PeopleItem>

    suspend fun saveArtistsToDb(artists: List<PeopleItem>)

    suspend fun clearArtists()
}