package com.xtremepixel.moviescleanarchitecture.data.repository

import com.xtremepixel.moviescleanarchitecture.models.*
import retrofit2.Response

interface RemoteDataSource {

    suspend fun getMovies(): Response<MovieListResponse>

    suspend fun getTvShows(): Response<TvShowListResponse>

    suspend fun getArtist(): Response<PeopleListResponse>
}