package com.xtremepixel.moviescleanarchitecture.data.datasources

import com.xtremepixel.moviescleanarchitecture.domain.models.MovieItem
import com.xtremepixel.moviescleanarchitecture.domain.models.PeopleItem
import com.xtremepixel.moviescleanarchitecture.domain.models.TvShowItem

class CacheDataSourceImpl: CachedDataSource {

    private var moviesList = ArrayList<MovieItem>()
    private var tvShowsList = ArrayList<TvShowItem>()
    private var artistsList = ArrayList<PeopleItem>()

    override suspend fun getMoviesFromCached(): List<MovieItem> = moviesList

    override suspend fun saveMoviesToCached(movies: List<MovieItem>) {
      moviesList.clear()
        moviesList.addAll(movies)
    }

    override suspend fun getTvShowsFromCached(): List<TvShowItem> = tvShowsList

    override suspend fun saveTvShowsToCached(tvShows: List<TvShowItem>) {
       tvShowsList.clear()
        tvShowsList.addAll(tvShows)
    }

    override suspend fun getArtistsFromCached(): List<PeopleItem> = artistsList

    override suspend fun saveArtistsToCached(artist: List<PeopleItem>) {
        artistsList.clear()
        artistsList.addAll(artist)
    }
}