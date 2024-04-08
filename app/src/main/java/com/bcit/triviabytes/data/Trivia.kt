package com.bcit.triviabytes.data

import com.google.gson.annotations.SerializedName

data class TriviaSet(
    @SerializedName("response_code")
    val response: Int,
    val results: List<TriviaQuestion>
)

data class TriviaQuestion(
    val type: String,
    val difficulty: String,
    val category: String,
    val question: String,
    @SerializedName("correct_answer")
    val correctAnswer: String,
    @SerializedName("incorrect_answers")
    val incorrectAnswers: List<String>
)