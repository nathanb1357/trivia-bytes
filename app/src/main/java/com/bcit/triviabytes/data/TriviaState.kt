package com.bcit.triviabytes.data

import androidx.compose.runtime.mutableStateListOf

class TriviaState(private val triviaRepo: TriviaRepository) {
    var triviaQuestions = mutableStateListOf<TriviaQuestion>()

}