package com.example.vcs_project16.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.*
import com.example.vcs_project16.presentation.home.HomeScreen

@Composable
fun NavGraph() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = "home"

    ) {
        composable(
            "home"
        ) {
            HomeScreen()
        }
    }
}