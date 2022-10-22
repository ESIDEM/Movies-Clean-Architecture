package com.xtremepixel.moviescleanarchitecture.domain.usecase

import com.xtremepixel.moviescleanarchitecture.domain.repository.MoviesRepository

class GetArtistsUseCase(private val moviesRepository: MoviesRepository) {

    suspend fun execute() = moviesRepository.getArtists()

}