package com.example.vcs_project16.presentation.detail

import com.example.vcs_project16.domain.model.News
data class DetailState(
    val isLoading: Boolean = true,
    val news: News? = null
)