package com.example.vcs_project16.presentation.detail

import android.content.Intent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.OpenInNew
import androidx.compose.material.icons.filled.CalendarMonth
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Public
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.core.net.toUri
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.example.vcs_project16.ui.theme.AuthorColor
import com.example.vcs_project16.ui.theme.DateColor
import com.example.vcs_project16.ui.theme.SourceColor
import com.example.vcs_project16.utils.cleanContent
import com.example.vcs_project16.utils.toNewsDate

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen(
    onBack: () -> Unit,
    viewModel: DetailViewModel = hiltViewModel()
) {
    val state = viewModel.state
    val context = LocalContext.current
    if (state.isLoading) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator()
        }
        return
    }
    val article = state.news ?: return
    val previewContent =
        article.content
            .cleanContent()
            .ifBlank {
                article.description
            }
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "News Detail"
                    )

                },
                navigationIcon = {
                    IconButton(
                        onClick = onBack
                    ) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = null
                        )

                    }
                }
            )
        }
    ) { padding ->
        LazyColumn(
            state = rememberLazyListState(),
            modifier = Modifier
                .fillMaxSize()
                .padding(padding),
            contentPadding = PaddingValues(
                bottom = 32.dp
            )
        ) {
            item {
                AsyncImage(
                    model = article.imageUrl,
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(280.dp),
                    contentScale = ContentScale.Crop
                )
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp)
                ) {
                    Text(
                        text = article.title,
                        style =
                            MaterialTheme
                                .typography
                                .headlineSmall,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(
                        Modifier.height(16.dp)
                    )
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            imageVector = Icons.Default.Public,
                            contentDescription = null,
                            tint = SourceColor
                        )
                        Spacer(
                            Modifier.width(8.dp)
                        )
                        Text(
                            text = article.source,
                            color = SourceColor,
                            fontWeight = FontWeight.SemiBold
                        )
                    }
                    Spacer(
                        Modifier.height(12.dp)
                    )
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            imageVector = Icons.Default.Person,
                            contentDescription = null,
                            tint = AuthorColor
                        )
                        Spacer(
                            Modifier.width(8.dp)
                        )
                        Text(
                            text = article.author,
                            color = AuthorColor
                        )
                    }
                    Spacer(
                        Modifier.height(12.dp)
                    )
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            imageVector = Icons.Default.CalendarMonth,
                            contentDescription = null,
                            tint = DateColor
                        )
                        Spacer(
                            Modifier.width(8.dp)
                        )
                        Text(
                            text = article.publishedAt.toNewsDate(),
                            color = DateColor

                        )
                    }
                    Spacer(
                        Modifier.height(16.dp)
                    )
                    Text(
                        text = "Summary",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(
                        Modifier.height(12.dp)
                    )
                    Text(
                        text = article.description,
                        style =
                            MaterialTheme
                                .typography
                                .bodyLarge
                    )
                    Spacer(
                        Modifier.height(28.dp)
                    )
                    Text(
                        text = "Article Preview",
                        style =
                            MaterialTheme
                                .typography
                                .titleMedium,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(
                        Modifier.height(12.dp)
                    )
                    Text(
                        text = previewContent,
                        style =
                            MaterialTheme
                                .typography
                                .bodyLarge

                    )
                    Spacer(
                        Modifier.height(28.dp)
                    )
                    ElevatedCard(
                        modifier = Modifier.fillMaxWidth()

                    ) {
                        Column(
                            modifier = Modifier.padding(16.dp)
                        ) {
                            Text(
                                text = "Continue reading on the publisher's website.",
                                style =
                                    MaterialTheme
                                        .typography
                                        .bodyMedium
                            )
                            Spacer(
                                Modifier.height(12.dp)
                            )
                            Button(
                                modifier = Modifier.fillMaxWidth(),
                                onClick = {
                                    context.startActivity(
                                        Intent(
                                            Intent.ACTION_VIEW,
                                            article
                                                .articleUrl
                                                .toUri()
                                        )
                                    )
                                }
                            ) {
                                Icon(
                                    imageVector = Icons.AutoMirrored.Filled.OpenInNew,
                                    contentDescription = null
                                )
                                Spacer(
                                    Modifier.width(8.dp)
                                )
                                Text(
                                    "Read Full Article"
                                )

                            }
                        }
                    }
                }
            }
        }
    }
}