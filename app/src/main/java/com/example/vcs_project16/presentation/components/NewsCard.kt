package com.example.vcs_project16.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CalendarMonth
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Public
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.vcs_project16.domain.model.News
import com.example.vcs_project16.ui.theme.AuthorColor
import com.example.vcs_project16.ui.theme.DateColor
import com.example.vcs_project16.ui.theme.SourceColor
import com.example.vcs_project16.utils.toNewsDate
import com.example.vcs_project16.R
@Composable
fun NewsCard(
    news: News,
    onClick: () -> Unit
) {
    ElevatedCard(
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                onClick()
            },
        shape = RoundedCornerShape(24.dp),
        elevation = CardDefaults
            .elevatedCardElevation(
                defaultElevation = 6.dp
            )
    ) {
        Column {
            AsyncImage(
                model = news.imageUrl,
                contentDescription = null,
                placeholder =
                    painterResource(
                        R.drawable.no_image
                    ),
                error =
                    painterResource(
                        R.drawable.no_image
                    ),
                fallback =
                    painterResource(
                        R.drawable.no_image
                    ),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(220.dp)
                    .clip(
                        RoundedCornerShape(
                            topStart = 24.dp,
                            topEnd = 24.dp
                        )
                    ),
                contentScale = ContentScale.Crop
            )
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Text(
                    text = news.title,
                    style =
                        MaterialTheme
                            .typography
                            .titleMedium,
                    fontWeight = FontWeight.Bold,
                    maxLines = 2
                )
                Spacer(
                    Modifier.height(8.dp)
                )
                Text(
                    text = news.description,
                    style =
                        MaterialTheme
                            .typography
                            .bodyMedium,
                    maxLines = 3
                )
                Spacer(
                    Modifier.height(12.dp)
                )
                Column(
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Row {
                        Icon(
                            imageVector = Icons.Default.Public,
                            contentDescription = null,
                            tint = SourceColor
                        )
                        Spacer(
                            Modifier.width(6.dp)
                        )
                        Text(
                            text = news.source,
                            color = SourceColor,
                            fontWeight = FontWeight.SemiBold
                        )
                    }
                    Row {
                        Icon(
                            imageVector = Icons.Default.Person,
                            contentDescription = null,
                            tint = AuthorColor
                        )
                        Spacer(
                            Modifier.width(6.dp)
                        )
                        Text(
                            text = news.author,
                            color = AuthorColor
                        )
                    }
                    Row {
                        Icon(
                            imageVector = Icons.Default.CalendarMonth,
                            contentDescription = null,
                            tint = DateColor
                        )
                        Spacer(
                            Modifier.width(6.dp)
                        )
                        Text(
                            text = news.publishedAt.toNewsDate(),
                            color = DateColor
                        )
                    }
                }
            }
        }
    }
}