package com.example.vcs_project16.presentation.home

import com.example.vcs_project16.domain.model.News

data class HomeState(
    val isLoading: Boolean = false,
    val isRefreshing: Boolean = false,
    val isOnline: Boolean = true,
    val searchQuery: String = "",
    val news: List<News> = emptyList(),
    val error: String? = null
)