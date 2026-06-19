package com.example.vcs_project16.di

import com.example.vcs_project16.domain.repository.NewsRepository
import com.example.vcs_project16.data.repository.NewsRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
@Module
@InstallIn(
    SingletonComponent::class
)

abstract class RepositoryModule {
    @Binds
    abstract fun bindNewsRepository(
        repository: NewsRepositoryImpl
    ): NewsRepository
}