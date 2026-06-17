package com.example.vcs_project16.presentation.home
sealed class HomeEvent {
    data class Search(
        val keyword: String
    ) : HomeEvent()
    data object Refresh : HomeEvent()
}