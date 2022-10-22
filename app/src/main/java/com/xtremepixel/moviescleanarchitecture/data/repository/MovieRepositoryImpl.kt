package com.xtremepixel.moviescleanarchitecture.data.repository

import android.util.Log
import com.xtremepixel.moviescleanarchitecture.domain.repository.MoviesRepository
import com.xtremepixel.moviescleanarchitecture.models.MovieItem
import com.xtremepixel.moviescleanarchitecture.models.PeopleItem
import com.xtremepixel.moviescleanarchitecture.models.TvShowItem

class MovieRepositoryImpl(
    private val remoteDataSource: RemoteDataSource,
    private val cachedDataSource: CachedDataSource,
    private val localDataSource: LocalDataSource
): MoviesRepository {
    override suspend fun getMovies(): List<MovieItem> = getMoviesFromCache()

    override suspend fun updateMovies(): List<MovieItem> {
        val newList = getMoviesFromApi()
        localDataSource.clearMovies()
        localDataSource.saveMoviesToDb(newList)
        cachedDataSource.saveMoviesToCached(newList)

        return newList
    }

    override suspend fun getTvShows(): List<TvShowItem>? {
        TODO("Not yet implemented")
    }

    override suspend fun updateTvShows(): List<TvShowItem>? {
        TODO("Not yet implemented")
    }

    override suspend fun getArtists(): List<PeopleItem>? {
        TODO("Not yet implemented")
    }

    override suspend fun updateArtists(): List<PeopleItem>? {
        TODO("Not yet implemented")
    }

    suspend fun getMoviesFromApi(): List<MovieItem> {
        val moviesList = ArrayList<MovieItem>()

        try {

            val response = remoteDataSource.getMovies().body()
            if (response!=null){
                moviesList.addAll(response.movieList)
            }

        } catch (e: Exception){
            Log.d("MovieRepository", e.message.toString())
        }

        return moviesList
    }

    suspend fun getMoviesFromDB(): List<MovieItem> {
        val moviesList = ArrayList<MovieItem>()

        try {
            moviesList.addAll(localDataSource.getMoviesFromDB())
        } catch (e: Exception){
            Log.d("MovieRepository", e.message.toString())
        }

        if (moviesList.size > 0){
            return moviesList
        }else {
            moviesList.addAll(getMoviesFromApi())
            localDataSource.saveMoviesToDb(moviesList)
        }

        return moviesList
    }

    suspend fun getMoviesFromCache(): List<MovieItem> {
        val moviesList = ArrayList<MovieItem>()

        try {
            moviesList.addAll(cachedDataSource.getMoviesFromCached())
        } catch (e: Exception){
            Log.d("MovieRepository", e.message.toString())
        }

        if (moviesList.size > 0){
            return moviesList
        }else {
            moviesList.addAll(getMoviesFromDB())
            cachedDataSource.saveMoviesToCached(moviesList)
        }

        return moviesList
    }
}