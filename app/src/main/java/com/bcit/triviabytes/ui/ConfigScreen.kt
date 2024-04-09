package com.bcit.triviabytes.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableIntState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun ConfigScreen(navController: NavController, configState: ConfigState) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color(0xFF281849)
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(120.dp))
            Text(
                text="Trivia Bytes",
                color = Color(0xFFCEC2EB),
                fontSize = 70.sp
            )
            TextField(
                value = configState.strAmount,
                onValueChange = { configState.onAmountChange(it) },
                label = { Text("Amount of Questions (1-100)") }
            )
            Button(
                onClick = { navController.navigate("trivia/${configState.intAmount}") }
            ) {
                Text("Start")
            }
        }
    }
}