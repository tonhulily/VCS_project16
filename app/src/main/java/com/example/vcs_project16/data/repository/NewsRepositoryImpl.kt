package com.example.vcs_project16.data.repository

import com.example.vcs_project16.data.local.dao.NewsDao
import com.example.vcs_project16.data.mapper.toDomain
import com.example.vcs_project16.data.mapper.toEntity
import com.example.vcs_project16.data.remote.api.NewsApi
import com.example.vcs_project16.domain.model.News
import com.example.vcs_project16.domain.repository.NewsRepository
import com.example.vcs_project16.utils.Constants
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class NewsRepositoryImpl @Inject constructor(
    private val api: NewsApi,
    private val dao: NewsDao
) : NewsRepository {
    override fun getNews(): Flow<List<News>> {
        return dao
            .getAllNews()
            .map { list ->
                list.map {
                    it.toDomain()
                }
            }
    }

    override fun searchNews(
        keyword: String
    ): Flow<List<News>> {
        return dao
            .searchNews(keyword)
            .map { list ->
                list.map {
                    it.toDomain()
                }
            }
    }

    override suspend fun refresh() {
        try {
            val response =
                api.getTopHeadlines(
                    apiKey = Constants.API_KEY
                )
            dao.clear()
            dao.insertAll(
                response.articles.map {
                    it.toEntity()
                }
            )
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
    override suspend fun getNewsDetail(
        url: String
    ): News? {
        return dao
            .getNewsDetail(url)
            ?.toDomain()
    }
}