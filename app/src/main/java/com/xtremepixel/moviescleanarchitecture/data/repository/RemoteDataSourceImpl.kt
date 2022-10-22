package com.xtremepixel.moviescleanarchitecture.data.repository

import com.xtremepixel.moviescleanarchitecture.data.api.MoviesService
import com.xtremepixel.moviescleanarchitecture.models.*
import retrofit2.Response

class RemoteDataSourceImpl(
    private val apiService: MoviesService,
    private val apiKey: String
) : RemoteDataSource {
    override suspend fun getMovies(): Response<MovieListResponse> =
        apiService.getPopularMovies(apiKey)

    override suspend fun getTvShows(): Response<TvShowListResponse> =
        apiService.getPopularTvShows(apiKey)

    override suspend fun getArtist(): Response<PeopleListResponse> =
        apiService.getPopularArtists(apiKey)
}