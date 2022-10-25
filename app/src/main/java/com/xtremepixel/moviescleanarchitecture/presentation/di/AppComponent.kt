package com.xtremepixel.moviescleanarchitecture.presentation.di

import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class, DatabaseModule::class, DataSourcesModule::class,
        NetWorkModule::class, RepositoryModule::class, UseCaseModule::class
    ]
)
interface AppComponent {
}