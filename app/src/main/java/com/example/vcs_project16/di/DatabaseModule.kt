package com.example.vcs_project16.di

import android.content.Context
import androidx.room.Room
import com.example.vcs_project16.data.local.AppDatabase
import com.example.vcs_project16.data.local.dao.NewsDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(
    SingletonComponent::class
)
object DatabaseModule {
    @Provides
    @Singleton
    fun provideDatabase(
        @ApplicationContext context: Context
    ): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "news_db"
        ).build()
    }
    @Provides
    @Singleton
    fun provideNewsDao(
        database: AppDatabase
    ): NewsDao {
        return database.newsDao()
    }
}