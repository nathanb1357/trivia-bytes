package com.bcit.triviabytes

import android.app.Application
import com.bcit.triviabytes.data.TriviaRepository
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.gson.gson

class MainApp: Application() {
    private val client = HttpClient {
        install(ContentNegotiation) { gson() }
    }
    val triviaRepo = TriviaRepository(client)
}