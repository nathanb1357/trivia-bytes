package com.bcit.triviabytes.ui.states

import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.navigation.NavController
import com.bcit.triviabytes.data.TriviaQuestion
import com.bcit.triviabytes.data.TriviaRepository
import org.jsoup.Jsoup

class TriviaState(private val triviaRepo: TriviaRepository) {

    // Questions list
    var questions = mutableStateListOf<TriviaQuestion>()
    var maxScore = mutableIntStateOf(0)
    var actualScore = mutableIntStateOf(0)
    var currentQuestionIndex = mutableIntStateOf(0)
    var answerSelected = mutableStateOf(false)

    // Request questions from API and resets values
    suspend fun getQuestions(amount: Int) {
        questions.also {
            it.clear()
            it.addAll(triviaRepo.getTrivia(amount).results)
        }
        actualScore.intValue = 0
        maxScore.intValue = questions.size
        answerSelected.value = false
        currentQuestionIndex.intValue = 0
    }

    // Answers list
    fun getAnswers(question: TriviaQuestion): List<String> {
        val answers = mutableListOf(question.correctAnswer)
        answers.addAll(question.incorrectAnswers)
        answers.shuffle()
        return answers
    }

    // Moves to next question
    fun moveToNextQuestion(navController: NavController) {
        if (currentQuestionIndex.intValue < maxScore.intValue - 1) {
            answerSelected.value = false
            currentQuestionIndex.intValue++
        } else {
            navController.navigate("results")
        }
    }

    // Returns whether answer is correct
    val isCorrect: (String) -> Boolean = {
        answerSelected.value = true
        if (it == Jsoup.parse(questions[currentQuestionIndex.intValue].correctAnswer).text()) {
            actualScore.intValue++
            true
        } else false
    }
}