package com.example.vcs_project16.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.vcs_project16.domain.usecase.NewsUseCases
import com.example.vcs_project16.utils.NetworkMonitor
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val useCases: NewsUseCases,
    private val networkMonitor: NetworkMonitor
) : ViewModel() {
    var state = androidx.compose.runtime.mutableStateOf(HomeState())
        private set
    private var searchJob: Job? = null
    init {
        observeNetwork()
        loadNews()
        refreshNews()
    }
    private fun observeNetwork() {
        viewModelScope.launch {
            networkMonitor.isOnline.collect {
                state.value =
                    state.value.copy(
                        isOnline = it
                    )
            }
        }
    }
    private fun loadNews() {
        viewModelScope.launch {
            useCases
                .getNews()
                .collectLatest {
                    state.value =
                        state.value.copy(
                            news = it
                        )
                }
        }
    }
    private fun refreshNews() {
        viewModelScope.launch {
            useCases.refreshNews()
        }
    }
    fun onEvent(
        event: HomeEvent
    ) {
        when(event) {
            is HomeEvent.Search -> {
                search(event.keyword)
            }
            HomeEvent.Refresh -> {
                pullRefresh()
            }
        }
    }
    private fun pullRefresh() {
        viewModelScope.launch {
            state.value =
                state.value.copy(
                    isRefreshing = true
                )
            useCases.refreshNews()
            state.value =
                state.value.copy(
                    isRefreshing = false
                )
        }
    }
    private fun search(
        keyword: String
    ) {
        state.value =
            state.value.copy(
                searchQuery = keyword
            )
        searchJob?.cancel()
        searchJob =
            viewModelScope.launch {
                useCases
                    .searchNews(keyword)
                    .collectLatest {
                        state.value =
                            state.value.copy(
                                news = it
                            )
                    }
            }
    }
}