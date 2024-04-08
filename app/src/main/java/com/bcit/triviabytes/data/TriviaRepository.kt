package com.bcit.triviabytes.data

import com.google.gson.Gson
import com.google.gson.JsonObject
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get


const val URL = "https://opentdb.com/api.php?"

class TriviaRepository(private val client: HttpClient) {
    suspend fun getTrivia(amount: Int): TriviaSet {
        val response = client.get("${URL}amount=${amount}")
        val json = response.body<JsonObject>().toString()
        return Gson().fromJson(json, TriviaSet::class.java)
    }
}