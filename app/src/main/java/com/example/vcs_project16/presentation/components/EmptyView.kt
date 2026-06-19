package com.example.vcs_project16.presentation.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Article
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
@Composable
fun EmptyView() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                imageVector = Icons.AutoMirrored.Filled.Article,
                contentDescription = null,
                modifier = Modifier.size(72.dp),
                tint = Color(0xFF6C63FF)
            )
            Spacer(
                Modifier.height(16.dp)
            )
            Text(
                text = "No News Found",
                style =
                    MaterialTheme
                        .typography
                        .titleMedium,
                fontWeight = FontWeight.Bold
            )
            Spacer(
                Modifier.height(8.dp)
            )
            Text(
                text = "Try another keyword or refresh the news feed.",
                style =
                    MaterialTheme
                        .typography
                        .bodyMedium
            )
        }
    }
}