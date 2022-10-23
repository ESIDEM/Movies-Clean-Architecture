package com.xtremepixel.moviescleanarchitecture.data.datasources

import com.xtremepixel.moviescleanarchitecture.data.db.ArtistsDAO
import com.xtremepixel.moviescleanarchitecture.data.db.MoviesDAO
import com.xtremepixel.moviescleanarchitecture.data.db.TvShowsDAO
import com.xtremepixel.moviescleanarchitecture.domain.models.MovieItem
import com.xtremepixel.moviescleanarchitecture.domain.models.PeopleItem
import com.xtremepixel.moviescleanarchitecture.domain.models.TvShowItem

class LocalDataSourceImpl(
    private val moviesDAO: MoviesDAO,
    private val tvShowsDAO: TvShowsDAO,
    private val artistsDAO: ArtistsDAO
): LocalDataSource {
    override suspend fun getMoviesFromDB(): List<MovieItem> = moviesDAO.getMovies()

    override suspend fun saveMoviesToDb(movies: List<MovieItem>) = moviesDAO.saveMovies(movies)

    override suspend fun clearMovies() = moviesDAO.deleteAllMovies()

    override suspend fun getTvShowsFromDB(): List<TvShowItem> = tvShowsDAO.getTvShows()

    override suspend fun saveTvShowsToDb(tvShows: List<TvShowItem>) = tvShowsDAO.saveTvShows(tvShows)

    override suspend fun clearTvShows() = tvShowsDAO.deleteAllTvShows()

    override suspend fun getArtistsFromDB(): List<PeopleItem> = artistsDAO.getArtists()

    override suspend fun saveArtistsToDb(artists: List<PeopleItem>) = artistsDAO.saveArtists(artists)

    override suspend fun clearArtists() = artistsDAO.deleteAllArtists()
}