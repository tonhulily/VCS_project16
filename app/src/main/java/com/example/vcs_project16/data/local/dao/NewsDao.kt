package com.example.vcs_project16.data.local.dao

import androidx.room.*
import com.example.vcs_project16.data.local.entity.NewsEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface NewsDao {
    @Query("""
        SELECT * FROM news
        ORDER BY updatedAt DESC
    """)
    fun getAllNews():
            Flow<List<NewsEntity>>
    @Insert(
        onConflict = OnConflictStrategy.REPLACE
    )
    suspend fun insertAll(
        news: List<NewsEntity>
    )
    @Query("""
        SELECT * FROM news
        WHERE title LIKE '%' || :keyword || '%'
    """)
    fun searchNews(
        keyword: String
    ): Flow<List<NewsEntity>>
    @Query("""
        SELECT * FROM news
        WHERE articleUrl = :url
        LIMIT 1
    """)
    suspend fun getNewsDetail(
        url: String
    ): NewsEntity?
    @Query("DELETE FROM news")
    suspend fun clear()
}