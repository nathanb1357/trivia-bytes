package com.bcit.triviabytes.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TriviaAnswer(text: String, onClick: (String) -> Boolean, answerSelected: Boolean) {
    val defaultColor = Color(0xFFE6E6E6)
    val correctColor = Color(0xFFBAFDA0)
    val incorrectColor = Color(0xFFFFA7A7)

    // State to track the background color of the answer
    val backgroundColor = remember { mutableStateOf(defaultColor) }

    Card(
        colors = CardDefaults.cardColors(containerColor = backgroundColor.value),
        shape = RectangleShape,
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .clickable {
                if (!answerSelected) {
                    backgroundColor.value = if (onClick(text)) correctColor else incorrectColor
                }
            }
    ) {
        Text(
            text = text,
            fontSize = 26.sp,
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth(),
            textAlign = TextAlign.Center
        )
    }

    LaunchedEffect(text) {
        backgroundColor.value = defaultColor
    }
}