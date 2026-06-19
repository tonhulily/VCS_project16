package com.example.vcs_project16.presentation.detail

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.vcs_project16.domain.repository.NewsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.launch
@HiltViewModel
class DetailViewModel @Inject constructor(
    private val repository: NewsRepository,
    savedStateHandle: SavedStateHandle
) : ViewModel() {
    var state by mutableStateOf(
        DetailState()
    )
        private set
    init {
        val url =
            savedStateHandle
                .get<String>(
                    "articleUrl"
                ) ?: ""
        load(url)
    }
    private fun load(
        url: String
    ) {
        viewModelScope.launch {
            val news = repository.getNewsDetail(url)
            state =
                state.copy(
                    isLoading = false,
                    news = news
                )
        }
    }
}