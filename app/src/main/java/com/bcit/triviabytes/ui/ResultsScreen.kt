package com.bcit.triviabytes.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.bcit.triviabytes.ui.states.TriviaState

@Composable
fun ResultsScreen(navController: NavController, triviaState: TriviaState) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color(0xFF281849)
    ) {
        Column {
            Text("You got ${triviaState.actualScore.intValue} out of ${triviaState.maxScore.intValue}")
            Button(
                onClick = { navController.navigate("config") }
            ) {
                Text("Back")
            }
        }
    }
}