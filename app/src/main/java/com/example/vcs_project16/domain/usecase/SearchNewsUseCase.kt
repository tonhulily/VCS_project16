package com.example.vcs_project16.domain.usecase

import com.example.vcs_project16.domain.repository.NewsRepository
import javax.inject.Inject

class SearchNewsUseCase @Inject constructor(
    private val repository: NewsRepository
) {
    operator fun invoke(
        keyword: String
    ) = repository.searchNews(keyword)
}