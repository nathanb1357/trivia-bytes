package com.bcit.triviabytes.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.bcit.triviabytes.ui.states.TriviaState

@Composable
fun TriviaScreen(navController: NavController, triviaState: TriviaState) {
    val currentQuestion = triviaState.questions.getOrNull(triviaState.currentQuestionIndex.intValue)
    val currentAnswers = currentQuestion?.let { triviaState.getAnswers(it) } ?: emptyList()

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
                Text("Score: ${triviaState.actualScore.intValue}")
                Text(currentQuestion?.question ?: "")

                currentAnswers.forEach {
                    TriviaAnswer(
                        text = it,
                        onClick = triviaState.isCorrect,
                        answerSelected = triviaState.answerSelected.value
                    )
                }

                if (triviaState.answerSelected.value) {
                    Button(
                        onClick = { triviaState.moveToNextQuestion(navController) }
                    ) {
                        Text("Next")
                    }
                }
            }
        }
    }
}