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

        // Results Menu
        composable(
            route = "results/{score}",
            arguments = listOf(navArgument("score") { type = NavType.IntType})
        ) {
            val score = it.arguments!!.getInt("score")
            ResultsScreen(navController, triviaState, score)
        }
    }
}