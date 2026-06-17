package com.example.vcs_project16.domain.usecase

import com.example.vcs_project16.domain.repository.NewsRepository
import javax.inject.Inject

class RefreshNewsUseCase @Inject constructor(
    private val repository: NewsRepository
) {
    suspend operator fun invoke() {
        repository.refresh()

    }
}