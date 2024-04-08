package com.bcit.triviabytes.ui

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun MainContent(triviaState: TriviaState, configState: ConfigState) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "config"
    ) {
        // Config Menu
        composable("config") {
            ConfigScreen(navController, configState.strAmount, configState.onAmountChange)
        }

        // Trivia Menu
        composable("trivia/{amount}") {
            TriviaScreen(navController, triviaState)
        }
    }
}