package com.bcit.triviabytes.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.bcit.triviabytes.ui.states.ConfigState

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
                color = Color(0xFF86FAA8),
                fontSize = 75.sp
            )
            Spacer(modifier = Modifier.height(80.dp))
            TextField(
                value = configState.strAmount,
                modifier = Modifier.width(320.dp),
                textStyle = TextStyle.Default.copy(fontSize = 22.sp),
                onValueChange = { configState.onAmountChange(it) },
                label = { Text("Number of Questions (1-50)", fontSize = 16.sp) }
            )
            Spacer(modifier = Modifier.height(40.dp))
            Button(
                modifier = Modifier.width(140.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFE44DDC)),
                onClick = { navController.navigate("trivia/${configState.intAmount}") }
            ) {
                Text("Start", fontSize = 30.sp)
            }
        }
    }
}