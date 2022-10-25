package com.xtremepixel.moviescleanarchitecture.presentation.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.xtremepixel.moviescleanarchitecture.domain.usecase.GetArtistsUseCase
import com.xtremepixel.moviescleanarchitecture.domain.usecase.UpdateArtistsUseCase
import javax.inject.Inject

class ArtistsVM @Inject constructor(
    private val getArtistsUseCase: GetArtistsUseCase,
    private val updateArtistsUseCase: UpdateArtistsUseCase
): ViewModel() {

    fun getArtists() = liveData {
        val artistsList = getArtistsUseCase.execute()
        emit(artistsList)
    }

    fun updateArtists() = liveData {
        val artistsList = updateArtistsUseCase.execute()
        emit(artistsList)
    }
}