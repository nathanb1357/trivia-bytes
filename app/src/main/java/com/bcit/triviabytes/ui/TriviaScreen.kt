package com.bcit.triviabytes.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun TriviaScreen(navController: NavController, triviaState: TriviaState) {
    val maxScore = triviaState.questions.size
    Column {
        Text(maxScore.toString())
        Button(
            onClick = { navController.navigate("config") }
        ) {
            Text("Back")
        }
    }
}