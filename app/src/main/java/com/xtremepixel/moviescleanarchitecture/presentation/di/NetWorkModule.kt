package com.xtremepixel.moviescleanarchitecture.presentation.di

import com.xtremepixel.moviescleanarchitecture.data.api.MoviesService
import com.xtremepixel.moviescleanarchitecture.presentation.AppConstants
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetWorkModule {

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit = Retrofit.Builder().addConverterFactory(
        GsonConverterFactory.create()
    ).baseUrl(AppConstants.BASE_URL).build()

    @Singleton
    @Provides
    fun provideMovieService(retrofit: Retrofit): MoviesService = retrofit.create(MoviesService::class.java)
}