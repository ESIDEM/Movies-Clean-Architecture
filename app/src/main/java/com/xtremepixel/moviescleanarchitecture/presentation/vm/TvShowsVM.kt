package com.xtremepixel.moviescleanarchitecture.presentation.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.xtremepixel.moviescleanarchitecture.domain.usecase.GetTvShowsUseCase
import com.xtremepixel.moviescleanarchitecture.domain.usecase.UpdateTvShowsUseCase
import javax.inject.Inject

class TvShowsVM @Inject constructor(
    private val getTvShowsUseCase: GetTvShowsUseCase,
    private val updateTvShowsUseCase: UpdateTvShowsUseCase
): ViewModel() {

    fun getTvShows() = liveData {
        val tvShowList = getTvShowsUseCase.execute()
        emit(tvShowList)
    }

    fun updateTvShows() = liveData {
        val tvShowsList = updateTvShowsUseCase.execute()
        emit(tvShowsList)
    }
}