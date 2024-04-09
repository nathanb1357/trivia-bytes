package com.bcit.triviabytes.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.bcit.triviabytes.ui.states.TriviaState

@Composable
fun ResultsScreen(navController: NavController, triviaState: TriviaState) {
    val score = triviaState.actualScore.intValue
    val max = triviaState.maxScore.intValue
    val result = score.toFloat() / max.toFloat()

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color(0xFF281849)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            val statusMessage = when {
                result >= 1 -> "Perfect!"
                result >= 0.9 -> "Excellent!"
                result >= 0.8 -> "Great!"
                result >= 0.7 -> "Congrats!"
                result >= 0.5 -> "Close Call!"
                else -> "Better Luck Next Time!"
            }
            Spacer(modifier = Modifier.height(80.dp))
            Text(
                text = statusMessage,
                textAlign = TextAlign.Center,
                fontSize = 40.sp,
                color = Color(0xFF86FAA8)
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = "You got $score out of $max",
                textAlign = TextAlign.Center,
                fontSize = 28.sp,
                color = Color(0xFF86FAA8)
            )
            Spacer(modifier = Modifier.height(40.dp))
            Button(
                modifier = Modifier.width(130.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFE44DDC)),
                onClick = { navController.navigate("config") }
            ) {
                Text("Back", fontSize = 28.sp)
            }
        }
    }
}