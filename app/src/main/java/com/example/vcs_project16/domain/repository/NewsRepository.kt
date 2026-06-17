package com.example.vcs_project16.domain.repository

import com.example.vcs_project16.domain.model.News
import kotlinx.coroutines.flow.Flow

interface NewsRepository {
    fun getNews(): Flow<List<News>>
    fun searchNews(
        keyword: String
    ): Flow<List<News>>
    suspend fun refresh()
}