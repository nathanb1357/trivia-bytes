package com.bcit.triviabytes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.bcit.triviabytes.data.TriviaState
import com.bcit.triviabytes.ui.MainContent

class MainActivity: ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val triviaRepo = (application as MainApp).triviaRepo
        super.onCreate(savedInstanceState)
        setContent {
            val triviaState = TriviaState(triviaRepo)
            MainContent(triviaState)
        }
    }
}