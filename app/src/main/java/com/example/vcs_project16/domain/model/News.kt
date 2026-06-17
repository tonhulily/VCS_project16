package com.example.vcs_project16.domain.model

data class News(
    val articleUrl: String,
    val title: String,
    val description: String,
    val content: String,
    val imageUrl: String,
    val author: String,
    val source: String,
    val publishedAt: String
)