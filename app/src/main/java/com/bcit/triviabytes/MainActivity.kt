package com.bcit.triviabytes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.remember
import com.bcit.triviabytes.ui.TriviaState
import com.bcit.triviabytes.ui.ConfigState
import com.bcit.triviabytes.ui.MainContent
import kotlinx.coroutines.coroutineScope

class MainActivity: ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val triviaRepo = (application as MainApp).triviaRepo
        super.onCreate(savedInstanceState)
        setContent {
            val triviaState = remember { TriviaState(triviaRepo) }
            val configState = remember { ConfigState() }

            MainContent(triviaState, configState)
        }
    }
}