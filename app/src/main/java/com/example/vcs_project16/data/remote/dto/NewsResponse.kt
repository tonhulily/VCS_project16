package com.example.vcs_project16.data.remote.dto

data class NewsResponse(
    val status: String,
    val totalResults: Int,
    val articles: List<NewsDto>
)