package com.bcit.triviabytes.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
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
import org.jsoup.Jsoup


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
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.height(20.dp))
                Text(
                    text = "Score: ${triviaState.actualScore.intValue}",
                    color = Color(0xFF86FAA8),
                    fontSize = 30.sp
                )
                Divider(
                    modifier = Modifier
                        .padding(20.dp),
                    color = Color(0xFF86FAA8),
                    thickness = 1.dp
                )
                Text(
                    text = Jsoup.parse(currentQuestion?.question ?: "").text(),
                    color = Color.White,
                    fontSize = 32.sp,
                    textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.height(30.dp))
                currentAnswers.forEach {
                    TriviaAnswer(
                        text = Jsoup.parse(it).text(),
                        onClick = triviaState.isCorrect,
                        answerSelected = triviaState.answerSelected.value
                    )
                }
                Spacer(modifier = Modifier.height(30.dp))
                if (triviaState.answerSelected.value) {
                    Button(
                        modifier = Modifier.width(130.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFE44DDC)),
                        onClick = { triviaState.moveToNextQuestion(navController) }
                    ) {
                        Text("Next", fontSize = 30.sp)
                    }
                }
            }
        }
    }
}