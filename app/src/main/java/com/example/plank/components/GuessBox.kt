package com.example.plank.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun GuessBox(onLettersEntered: (Char) -> Unit) {
    var guessedLetter by remember { mutableStateOf("") }

    TextField(
        value = guessedLetter,
        onValueChange = { input ->
            if (input.length <= 1) {
                guessedLetter = input.uppercase()
            }
        }, modifier = Modifier.width(72.dp),
        textStyle = LocalTextStyle.current.copy(textAlign = TextAlign.Center, fontSize = 36.sp, fontWeight = FontWeight.Bold),
        singleLine = true
    )

    Spacer(modifier = Modifier.height(20.dp))

    Button( onClick = { if(guessedLetter.isNotEmpty()) {
            val char = guessedLetter[0]
            if(char.isLetter()) {
                onLettersEntered(char)
                guessedLetter = ""
            }
        }
    } ) {
            Text(
                "Guess",
                fontSize = 20.sp
            )}
}



