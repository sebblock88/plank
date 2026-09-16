package com.example.plank.components

import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

@Composable
fun GuessBox() {
    var guessedLetter by remember { mutableStateOf("") }

    TextField(
        value = guessedLetter,
        onValueChange = { guessedLetter = it })
}
