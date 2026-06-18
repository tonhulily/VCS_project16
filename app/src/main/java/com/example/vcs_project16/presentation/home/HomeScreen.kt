package com.example.vcs_project16.presentation.home

import android.net.Uri
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.material3.pulltorefresh.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.vcs_project16.presentation.components.NewsCard
import com.example.vcs_project16.presentation.components.NewsSearchBar
import com.example.vcs_project16.presentation.components.OfflineBanner
import com.example.vcs_project16.presentation.components.OnlineBanner
import com.example.vcs_project16.presentation.navigation.Routes
@OptIn(
    ExperimentalMaterial3Api::class
)
@Composable
fun HomeScreen(
    navController: NavController,
    viewModel: HomeViewModel = hiltViewModel()
) {
    val state = viewModel.state.value
    val pullState = rememberPullToRefreshState()
    Scaffold(
        topBar = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .statusBarsPadding()
                    .padding(
                        horizontal = 20.dp,
                        vertical = 10.dp
                    )
            ) {
                Text(
                    text = "NewsHub",
                    style = MaterialTheme.typography.headlineLarge
                )
                Text(
                    text = "Latest Headlines",
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.primary
                )
            }
        }
    ) { padding ->
        PullToRefreshBox(
            state = pullState,
            isRefreshing = state.isRefreshing,
            onRefresh = {
                viewModel.onEvent(
                    HomeEvent.Refresh
                )
            }
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding)
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
                            HomeEvent.Search(
                                it
                            )
                        )
                    }
                )
                Spacer(
                    Modifier.height(16.dp)
                )
                LazyColumn(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.spacedBy(24.dp),
                    contentPadding = PaddingValues(
                        bottom = WindowInsets
                            .navigationBars
                            .asPaddingValues()
                            .calculateBottomPadding() + 24.dp
                    )
                ) {
                    items(
                        state.news
                    ) { news ->
                        NewsCard(
                            news = news,
                            onClick = {
                                val encodedUrl =
                                    Uri.encode(
                                        news.articleUrl
                                    )
                                navController.navigate(
                                    "${Routes.DETAIL}/$encodedUrl"
                                )
                            }
                        )
                    }
                }
            }
        }
    }
}