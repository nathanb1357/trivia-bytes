package com.bcit.triviabytes.data

enum class ApiEndpoints(val url: String) {
    BASE("https://opentdb.com/api.php"),
    AMOUNT("${BASE.url}?amount=10")
}