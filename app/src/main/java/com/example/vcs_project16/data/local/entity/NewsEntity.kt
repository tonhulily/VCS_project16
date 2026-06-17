package com.example.vcs_project16.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity(tableName = "news")
data class NewsEntity(
    @PrimaryKey
    val articleUrl: String,
    val title: String,
    val description: String,
    val content: String,
    val imageUrl: String,
    val author: String,
    val source: String,
    val publishedAt: String,
    val updatedAt: Long
)