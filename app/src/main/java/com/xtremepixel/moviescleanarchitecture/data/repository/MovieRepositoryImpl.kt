package com.xtremepixel.moviescleanarchitecture.data.repository

import android.util.Log
import com.xtremepixel.moviescleanarchitecture.data.datasources.CachedDataSource
import com.xtremepixel.moviescleanarchitecture.data.datasources.LocalDataSource
import com.xtremepixel.moviescleanarchitecture.data.datasources.RemoteDataSource
import com.xtremepixel.moviescleanarchitecture.domain.repository.MoviesRepository
import com.xtremepixel.moviescleanarchitecture.domain.models.MovieItem
import com.xtremepixel.moviescleanarchitecture.domain.models.PeopleItem
import com.xtremepixel.moviescleanarchitecture.domain.models.TvShowItem

class MovieRepositoryImpl(
    private val remoteDataSource: RemoteDataSource,
    private val cachedDataSource: CachedDataSource,
    private val localDataSource: LocalDataSource
) : MoviesRepository {
    override suspend fun getMovies(): List<MovieItem> = getMoviesFromCache()

    override suspend fun updateMovies(): List<MovieItem> {
        val newList = getMoviesFromApi()
        localDataSource.clearMovies()
        localDataSource.saveMoviesToDb(newList)
        cachedDataSource.saveMoviesToCached(newList)

        return newList
    }

    override suspend fun getTvShows(): List<TvShowItem> = getTvShowsFromCache()

    override suspend fun updateTvShows(): List<TvShowItem> {
        val newList = getTvShowFromApi()
        localDataSource.clearTvShows()
        localDataSource.saveTvShowsToDb(newList)
        cachedDataSource.saveTvShowsToCached(newList)

        return newList

    }

    override suspend fun getArtists(): List<PeopleItem> = getArtistsFromCache()

    override suspend fun updateArtists(): List<PeopleItem> {
        val newList = getArtistsFromApi()
        localDataSource.clearArtists()
        localDataSource.saveArtistsToDb(newList)
        cachedDataSource.saveArtistsToCached(newList)

        return newList
    }

    suspend fun getMoviesFromApi(): List<MovieItem> {
        val moviesList = ArrayList<MovieItem>()

        try {

            val response = remoteDataSource.getMovies().body()
            if (response != null) {
                moviesList.addAll(response.movieList)
            }

        } catch (e: Exception) {
            Log.d("MovieRepository", e.message.toString())
        }

        return moviesList
    }

    suspend fun getMoviesFromDB(): List<MovieItem> {
        val moviesList = ArrayList<MovieItem>()

        try {
            moviesList.addAll(localDataSource.getMoviesFromDB())
        } catch (e: Exception) {
            Log.d("MovieRepository", e.message.toString())
        }

        if (moviesList.size > 0) {
            return moviesList
        } else {
            moviesList.addAll(getMoviesFromApi())
            localDataSource.saveMoviesToDb(moviesList)
        }

        return moviesList
    }

    suspend fun getMoviesFromCache(): List<MovieItem> {
        val moviesList = ArrayList<MovieItem>()

        try {
            moviesList.addAll(cachedDataSource.getMoviesFromCached())
        } catch (e: Exception) {
            Log.d("MovieRepository", e.message.toString())
        }

        if (moviesList.size > 0) {
            return moviesList
        } else {
            moviesList.addAll(getMoviesFromDB())
            cachedDataSource.saveMoviesToCached(moviesList)
        }

        return moviesList
    }

    suspend fun getTvShowFromApi(): List<TvShowItem> {
        val tvShowsList = ArrayList<TvShowItem>()

        try {

            val response = remoteDataSource.getTvShows().body()
            if (response != null) {
                tvShowsList.addAll(response.tvShowList)
            }

        } catch (e: Exception) {
            Log.d("MovieRepository", e.message.toString())
        }

        return tvShowsList
    }

    suspend fun getTvShowsFromDB(): List<TvShowItem> {
        val tvShowsList = ArrayList<TvShowItem>()

        try {
            tvShowsList.addAll(localDataSource.getTvShowsFromDB())
        } catch (e: Exception) {
            Log.d("MovieRepository", e.message.toString())
        }

        if (tvShowsList.size > 0) {
            return tvShowsList
        } else {
            tvShowsList.addAll(getTvShowFromApi())
            localDataSource.saveTvShowsToDb(tvShowsList)
        }

        return tvShowsList
    }

    suspend fun getTvShowsFromCache(): List<TvShowItem> {
        val tvShowsList = ArrayList<TvShowItem>()

        try {
            tvShowsList.addAll(cachedDataSource.getTvShowsFromCached())
        } catch (e: Exception) {
            Log.d("MovieRepository", e.message.toString())
        }

        if (tvShowsList.size > 0) {
            return tvShowsList
        } else {
            tvShowsList.addAll(getTvShowsFromDB())
            cachedDataSource.saveTvShowsToCached(tvShowsList)
        }

        return tvShowsList
    }

    suspend fun getArtistsFromApi(): List<PeopleItem> {
        val artistsList = ArrayList<PeopleItem>()

        try {

            val response = remoteDataSource.getArtist().body()
            if (response != null) {
                artistsList.addAll(response.peopleList)
            }

        } catch (e: Exception) {
            Log.d("MovieRepository", e.message.toString())
        }

        return artistsList
    }

    suspend fun getArtistsFromDB(): List<PeopleItem> {
        val artistList = ArrayList<PeopleItem>()

        try {
            artistList.addAll(localDataSource.getArtistsFromDB())
        } catch (e: Exception) {
            Log.d("MovieRepository", e.message.toString())
        }

        if (artistList.size > 0) {
            return artistList
        } else {
            artistList.addAll(getArtistsFromApi())
            localDataSource.saveArtistsToDb(artistList)
        }

        return artistList
    }

    suspend fun getArtistsFromCache(): List<PeopleItem> {
        val artistList = ArrayList<PeopleItem>()

        try {
            artistList.addAll(cachedDataSource.getArtistsFromCached())
        } catch (e: Exception) {
            Log.d("MovieRepository", e.message.toString())
        }

        if (artistList.size > 0) {
            return artistList
        } else {
            artistList.addAll(getArtistsFromDB())
            cachedDataSource.saveArtistsToCached(artistList)
        }

        return artistList
    }
}