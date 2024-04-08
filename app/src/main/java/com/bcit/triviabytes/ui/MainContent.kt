package com.bcit.triviabytes.ui

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.bcit.triviabytes.data.TriviaState

@Composable
fun MainContent(triviaState: TriviaState) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "config"
    ) {
        // Config Menu
        composable("config") {
            ConfigScreen(navController)
        }

        // Trivia Menu
        composable("trivia/{amount}") {
            TriviaScreen(navController, triviaState)
        }
    }
}