package com.xtremepixel.moviescleanarchitecture.data.api

import com.xtremepixel.moviescleanarchitecture.domain.models.MovieListResponse
import com.xtremepixel.moviescleanarchitecture.domain.models.PeopleListResponse
import com.xtremepixel.moviescleanarchitecture.domain.models.TvShowListResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MoviesService {

    @GET("movie/popular")
    suspend fun getPopularMovies(@Query("apk_key") apiKey: String): Response<MovieListResponse>

    @GET("tv/popular")
    suspend fun getPopularTvShows(@Query("apk_key") apiKey: String): Response<TvShowListResponse>

    @GET("person/popular")
    suspend fun getPopularArtists(@Query("apk_key") apiKey: String): Response<PeopleListResponse>
}