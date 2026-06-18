package com.example.vcs_project16.presentation.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.*
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
            Text(
                text = "📰",
                style = MaterialTheme.typography.displayMedium
            )
            Spacer(
                Modifier.height(12.dp)
            )
            Text(
                text = "No news found"
            )
        }
    }
}