package com.example.vcs_project16.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun OfflineBanner() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                Color(0xFFFF9800)
            )
            .padding(12.dp)
    ) {
        Text(
            text = "⚠ Offline Mode - Using Cached Data",
            color = Color.White
        )
    }
}