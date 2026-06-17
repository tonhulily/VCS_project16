package com.example.vcs_project16.presentation.home

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.material3.pulltorefresh.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

@OptIn(
    ExperimentalMaterial3Api::class
)
@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel()
) {
    val state = viewModel.state.value
    val pullState = rememberPullToRefreshState()
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        "Offline First News"
                    )
                }
            )
        }
    ) { padding ->
        PullToRefreshBox(
            isRefreshing = state.isRefreshing,
            onRefresh = {
                viewModel.onEvent(
                    HomeEvent.Refresh
                )
            },
            state = pullState
        ) {
            Column(
                modifier = Modifier
                    .padding(padding)
                    .fillMaxSize()
                    .padding(16.dp)
            ) {
                if (state.isOnline) {
                    OnlineBanner()
                } else {
                    OfflineBanner()
                }
                Spacer(
                    Modifier.height(12.dp)
                )
                NewsSearchBar(
                    value = state.searchQuery,
                    onValueChange = {
                        viewModel.onEvent(
                            HomeEvent.Search(it)
                        )
                    }
                )
                Spacer(
                    Modifier.height(16.dp)
                )
                if (state.news.isEmpty()) {
                    EmptyView()
                } else {
                    LazyColumn(
                        verticalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        items(
                            state.news
                        ) {
                            NewsCard(it)
                        }
                    }
                }
            }
        }
    }
}