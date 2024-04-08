package com.bcit.triviabytes.ui

import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun TriviaScreen(navController: NavController, triviaState: TriviaState) {
    val maxScore = triviaState.questions.size
}