package com.bcit.triviabytes.data

data class TriviaQuestion(
    val id: String,
    val question: String,
    val options: List<TriviaOption>
)

data class TriviaOption(
    val answer: String
)