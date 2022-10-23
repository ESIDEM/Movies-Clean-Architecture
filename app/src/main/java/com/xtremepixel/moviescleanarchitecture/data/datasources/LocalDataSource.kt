package com.xtremepixel.moviescleanarchitecture.data.datasources

import com.xtremepixel.moviescleanarchitecture.domain.models.MovieItem
import com.xtremepixel.moviescleanarchitecture.domain.models.PeopleItem
import com.xtremepixel.moviescleanarchitecture.domain.models.TvShowItem

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