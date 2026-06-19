package com.example.vcs_project16.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CloudDone
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
@Composable
fun OnlineBanner() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                color = Color(0xFF00C853),
                shape = RoundedCornerShape(16.dp)
            )
            .padding(
                horizontal = 16.dp,
                vertical = 12.dp
            ),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = Icons.Default.CloudDone,
            contentDescription = null,
            tint = Color.White
        )
        Spacer(
            Modifier.width(12.dp)
        )
        Text(
            text = "Connected",
            color = Color.White,
            fontWeight = FontWeight.Bold,
            style =
                MaterialTheme
                    .typography
                    .bodyLarge
        )
    }
}