package com.example.vcs_project16.domain.usecase

import com.example.vcs_project16.domain.repository.NewsRepository
import javax.inject.Inject

class GetNewsUseCase @Inject constructor(
    private val repository: NewsRepository
) {
    operator fun invoke() = repository.getNews()
}