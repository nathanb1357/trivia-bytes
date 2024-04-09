package com.bcit.triviabytes.ui.states

import androidx.compose.runtime.mutableStateListOf
import com.bcit.triviabytes.data.TriviaQuestion
import com.bcit.triviabytes.data.TriviaRepository

class TriviaState(private val triviaRepo: TriviaRepository) {
    var questions = mutableStateListOf<TriviaQuestion>()

    suspend fun getQuestions(amount: Int) {
        questions.also {
            it.clear()
            it.addAll(triviaRepo.getTrivia(amount).results)
        }
    }

    fun getAnswers(question: TriviaQuestion): List<String> {
        val answers = mutableListOf(question.correctAnswer)
        answers.addAll(question.incorrectAnswers)
        answers.shuffle()
        return answers
    }
}