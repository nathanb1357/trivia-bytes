package com.bcit.triviabytes.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun TriviaAnswer(text: String, onClick: (String) -> Boolean, answerSelected: Boolean) {
    val correctColor = Color(0xFFBAFDA0)
    val incorrectColor = Color(0xFFFFA7A7)

    // State to track the background color of the answer
    val backgroundColor = remember { mutableStateOf(Color(0xFFFFFFFF)) }

    Card(
        modifier = Modifier
            .clickable {
                if (!answerSelected) {
                    backgroundColor.value = if (onClick(text)) correctColor else incorrectColor
                }
            }
            .background(color = backgroundColor.value)
    ) {
        Text(text)
    }

    LaunchedEffect(text) {
        backgroundColor.value = Color(0xFFFFFFFF)
    }
}