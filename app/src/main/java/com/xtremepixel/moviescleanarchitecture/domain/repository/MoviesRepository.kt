package com.xtremepixel.moviescleanarchitecture.domain.repository

import com.xtremepixel.moviescleanarchitecture.domain.models.MovieItem
import com.xtremepixel.moviescleanarchitecture.domain.models.PeopleItem
import com.xtremepixel.moviescleanarchitecture.domain.models.TvShowItem

interface MoviesRepository {

    suspend fun getMovies(): List<MovieItem>?

    suspend fun updateMovies(): List<MovieItem>?

    suspend fun getTvShows(): List<TvShowItem>?

    suspend fun updateTvShows(): List<TvShowItem>?

    suspend fun getArtists(): List<PeopleItem>?

    suspend fun updateArtists(): List<PeopleItem>?
}