package com.xtremepixel.moviescleanarchitecture.data.datasources

import com.xtremepixel.moviescleanarchitecture.domain.models.MovieListResponse
import com.xtremepixel.moviescleanarchitecture.domain.models.PeopleListResponse
import com.xtremepixel.moviescleanarchitecture.domain.models.TvShowListResponse
import retrofit2.Response

interface RemoteDataSource {

    suspend fun getMovies(): Response<MovieListResponse>

    suspend fun getTvShows(): Response<TvShowListResponse>

    suspend fun getArtist(): Response<PeopleListResponse>
}