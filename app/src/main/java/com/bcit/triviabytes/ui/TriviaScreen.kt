package com.bcit.triviabytes.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.bcit.triviabytes.ui.states.TriviaState

@Composable
fun TriviaScreen(navController: NavController, triviaState: TriviaState) {
    var currentQuestionIndex by remember { mutableIntStateOf(0) }
    val currentQuestion = triviaState.questions.getOrNull(currentQuestionIndex)
    val currentAnswers = currentQuestion?.let { triviaState.getAnswers(it) } ?: emptyList()
    var answerSelected by remember { mutableStateOf(false) }
    var currentScore by remember { mutableIntStateOf(0) }
    val maxScore = triviaState.questions.size

    val isCorrect: (String) -> Boolean = {
        answerSelected = true
        if (it == currentQuestion?.correctAnswer) {
            currentScore++
            true
        } else false
    }

    fun moveToNextQuestion() {
        if (currentQuestionIndex < maxScore - 1) {
            answerSelected = false
            currentQuestionIndex++
        } else {
            navController.navigate("results")
        }
    }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color(0xFF281849)
    ) {
        if (triviaState.questions.isEmpty()) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        } else {
            Column {
                Text("Score: $currentScore")
                Text(currentQuestion?.question ?: "")

                currentAnswers.forEach {
                    TriviaAnswer(
                        text = it,
                        onClick = isCorrect,
                        answerSelected = answerSelected
                    )
                }

                if (answerSelected) {
                    Button(
                        onClick = { moveToNextQuestion() }
                    ) {

                    }
                }

                Button(
                    onClick = { navController.navigate("config") }
                ) {
                    Text("Back")
                }
            }
        }
    }
}