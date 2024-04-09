package com.bcit.triviabytes.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

@Composable
fun MainContent(triviaState: TriviaState, configState: ConfigState) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "config"
    ) {
        // Config Menu
        composable("config") {
            ConfigScreen(navController, configState)
        }

        // Trivia Menu
        composable(
            route = "trivia/{amount}",
            arguments = listOf(navArgument("amount") { type = NavType.IntType })
        ) {
            val amount = it.arguments?.getInt("amount") ?: 10
            LaunchedEffect(Unit) { triviaState.getQuestions(amount) }
            TriviaScreen(navController, triviaState)
        }
    }
}