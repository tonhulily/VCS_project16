package com.example.vcs_project16.data.local.dao

import androidx.room.*
import com.example.vcs_project16.data.local.entity.NewsEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface NewsDao {
    @Query("""
        SELECT * FROM news
        ORDER BY id DESC
    """)
    fun getAllNews(): Flow<List<NewsEntity>>
    @Insert(
        onConflict = OnConflictStrategy.REPLACE
    )
    suspend fun insertAll(
        news: List<NewsEntity>
    )
    @Query("DELETE FROM news")
    suspend fun clear()
    @Query("""
        SELECT * FROM news
        WHERE title LIKE '%' || :keyword || '%'
        ORDER BY id DESC
    """)
    fun searchNews(
        keyword: String
    ): Flow<List<NewsEntity>>
}