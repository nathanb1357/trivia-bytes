package com.bcit.triviabytes.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.bcit.triviabytes.ui.states.ConfigState
import com.bcit.triviabytes.ui.states.TriviaState

@Composable
fun MainContent(triviaState: TriviaState, configState: ConfigState) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "config"
    ) {

        // Config Screen
        composable("config") {
            ConfigScreen(navController, configState)
        }

        // Trivia Screen
        composable(
            route = "trivia/{amount}",
            arguments = listOf(navArgument("amount") { type = NavType.IntType })
        ) {
            val amount = it.arguments?.getInt("amount") ?: 10
            LaunchedEffect(Unit) { triviaState.getQuestions(amount) }
            TriviaScreen(navController, triviaState)
        }

        // Results Screen
        composable("results") {
            ResultsScreen(navController, triviaState)
        }
    }
}