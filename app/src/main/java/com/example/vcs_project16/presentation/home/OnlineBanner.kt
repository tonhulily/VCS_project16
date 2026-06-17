package com.example.vcs_project16.presentation.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun OnlineBanner() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                Color(0xFF00C853)
            )
            .padding(12.dp)
    ) {
        Text(
            text = "🟢 Connected",
            color = Color.White
        )
    }
}