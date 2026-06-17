package com.example.vcs_project16

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.vcs_project16.presentation.navigation.NavGraph
import com.example.vcs_project16.ui.theme.OfflineFirstTheme
import dagger.hilt.android.AndroidEntryPoint
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(
        savedInstanceState: Bundle?
    ) {
        super.onCreate(
            savedInstanceState
        )
        setContent {
            OfflineFirstTheme {
                NavGraph()
            }
        }
    }
}