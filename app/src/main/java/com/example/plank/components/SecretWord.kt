package com.example.plank.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp

@Composable
fun SecretWord(secretWord: String, guessed: Set<Char>) {
    Row(modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center) {
        secretWord.forEach { char ->
            val text = if(char in guessed) "$char " else "_ "

            Text(
                text,
                fontSize = 50.sp,
                textAlign = TextAlign.Center
            )
        }
    }
}