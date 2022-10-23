package com.xtremepixel.moviescleanarchitecture.data.datasources

import com.xtremepixel.moviescleanarchitecture.data.api.MoviesService
import com.xtremepixel.moviescleanarchitecture.domain.models.MovieListResponse
import com.xtremepixel.moviescleanarchitecture.domain.models.PeopleListResponse
import com.xtremepixel.moviescleanarchitecture.domain.models.TvShowListResponse
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