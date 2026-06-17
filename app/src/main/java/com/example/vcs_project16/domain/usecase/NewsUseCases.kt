package com.example.vcs_project16.domain.usecase

data class NewsUseCases(
    val getNews: GetNewsUseCase,
    val searchNews: SearchNewsUseCase,
    val refreshNews: RefreshNewsUseCase
)