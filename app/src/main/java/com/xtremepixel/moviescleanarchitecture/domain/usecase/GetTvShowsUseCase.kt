package com.xtremepixel.moviescleanarchitecture.domain.usecase

import com.xtremepixel.moviescleanarchitecture.domain.repository.MoviesRepository

class GetTvShowsUseCase(private val moviesRepository: MoviesRepository) {

    suspend fun execute() = moviesRepository.getTvShows()

}