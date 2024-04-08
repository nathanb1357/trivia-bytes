package com.bcit.triviabytes.data

import com.google.gson.Gson
import com.google.gson.JsonObject
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

enum class ApiEndpoints(val url: String) {
    BASE("https://opentdb.com/api.php"),
    AMOUNT("${BASE.url}?amount=10")
}

class TriviaRepository(private val client: HttpClient) {
    suspend fun getTrivia(): TriviaSet {
        val response = client.get(ApiEndpoints.AMOUNT.url)
        val json = response.body<JsonObject>().toString()
        return Gson().fromJson(json, TriviaSet::class.java)
    }
}