package com.xtremepixel.moviescleanarchitecture.presentation.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.xtremepixel.moviescleanarchitecture.domain.usecase.GetMoviesUseCase
import com.xtremepixel.moviescleanarchitecture.domain.usecase.UpdateMoviesUseCase
import javax.inject.Inject

class MoviesVM @Inject constructor(
    private val getMoviesUseCase: GetMoviesUseCase,
    private val updateMoviesUseCase: UpdateMoviesUseCase
): ViewModel() {

    fun getMovies() = liveData {
        val moviesList = getMoviesUseCase.execute()
        emit(moviesList)
    }

    fun updateMovies() = liveData {
        val moviesList = updateMoviesUseCase.execute()
        emit(moviesList)
    }
}