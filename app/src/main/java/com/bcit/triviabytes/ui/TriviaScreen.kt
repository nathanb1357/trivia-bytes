package com.bcit.triviabytes.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController

@Composable
fun TriviaScreen(navController: NavController, triviaState: TriviaState) {
    val maxScore = triviaState.questions.size
    if (triviaState.questions.isEmpty()) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator()
        }
    } else {
        Column {
            Text(maxScore.toString())
            Text(triviaState.questions[0].question)
            Button(
                onClick = { navController.navigate("config") }
            ) {
                Text("Back")
            }
        }
    }
}