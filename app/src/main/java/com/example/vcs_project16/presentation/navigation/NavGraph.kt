package com.example.vcs_project16.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.*
import androidx.navigation.navArgument
import com.example.vcs_project16.presentation.detail.DetailScreen
import com.example.vcs_project16.presentation.home.HomeScreen
object Routes {
    const val HOME = "home"
    const val DETAIL = "detail"
}
@Composable
fun NavGraph() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Routes.HOME
    ) {
        composable(
            Routes.HOME
        ) {
            HomeScreen(
                navController
            )
        }
        composable(
            route = "${Routes.DETAIL}/{articleUrl}",
            arguments =
                listOf(
                    navArgument(
                        "articleUrl"
                    ) {
                        type = NavType.StringType
                    }
                )
        ) {
            DetailScreen(
                onBack = {
                    navController.popBackStack()

                }

            )
        }
    }
}