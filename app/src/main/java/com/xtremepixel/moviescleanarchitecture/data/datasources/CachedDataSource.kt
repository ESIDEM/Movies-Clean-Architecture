package com.xtremepixel.moviescleanarchitecture.data.datasources

import com.xtremepixel.moviescleanarchitecture.domain.models.MovieItem
import com.xtremepixel.moviescleanarchitecture.domain.models.PeopleItem
import com.xtremepixel.moviescleanarchitecture.domain.models.TvShowItem

interface CachedDataSource {

    suspend fun getMoviesFromCached(): List<MovieItem>

    suspend fun saveMoviesToCached(movies: List<MovieItem>)

    suspend fun getTvShowsFromCached(): List<TvShowItem>

    suspend fun saveTvShowsToCached(tvShows: List<TvShowItem>)

    suspend fun getArtistsFromCached(): List<PeopleItem>

    suspend fun saveArtistsToCached(artist: List<PeopleItem>)
}