package com.example.vcs_project16.presentation.home

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.vcs_project16.domain.model.News
import com.example.vcs_project16.ui.theme.Primary
import com.example.vcs_project16.ui.theme.TextSecondary

@Composable
fun NewsCard(
    news: News
) {
    ElevatedCard(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(24.dp),
        elevation =
            CardDefaults.elevatedCardElevation(
                defaultElevation = 8.dp
            )
    ) {
        Column(
            modifier = Modifier.padding(20.dp)
        ) {
            Text(
                text = news.title,
                fontSize = 20.sp,
                color = Primary
            )
            Spacer(
                modifier = Modifier.height(10.dp)
            )
            Text(
                text = news.body,
                color = TextSecondary,
                lineHeight = 22.sp
            )
        }
    }
}