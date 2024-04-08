package com.bcit.triviabytes.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.core.text.isDigitsOnly

class ConfigState {
    // Amount config
    var strAmount by mutableStateOf("10")
    var intAmount by mutableIntStateOf(10)
    val onAmountChange: (String) -> Unit = {
        if (it.isNotEmpty() && it.isDigitsOnly()) {
            val intValue = it.toInt()
            if (intValue in 1..100) {
                strAmount = it
                intAmount = intValue
            }
        } else {
            strAmount = ""
        }
    }
}