package com.bcit.triviabytes.data

import androidx.compose.runtime.mutableStateListOf

class TriviaState(private val triviaRepo: TriviaRepository) {
    var questions = mutableStateListOf<TriviaQuestion>()

    suspend fun getQuestions(amount: Int) {
        questions.also {
            it.clear()
            it.addAll(triviaRepo.getTrivia(amount).results)
        }
    }
}