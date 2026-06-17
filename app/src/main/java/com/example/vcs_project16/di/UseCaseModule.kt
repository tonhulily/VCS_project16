package com.example.vcs_project16.di

import com.example.vcs_project16.domain.repository.NewsRepository
import com.example.vcs_project16.domain.usecase.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(
    SingletonComponent::class
)
object UseCaseModule {
    @Provides
    fun provideNewsUseCases(
        repository: NewsRepository
    ): NewsUseCases {
        return NewsUseCases(
            getNews = GetNewsUseCase(repository),
            searchNews = SearchNewsUseCase(repository),
            refreshNews = RefreshNewsUseCase(repository)
        )
    }
}