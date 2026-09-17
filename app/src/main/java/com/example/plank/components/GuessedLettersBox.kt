package com.example.plank.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun GuessedLettersBox(guessed: Set<Char>, secretWord: String) {

    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Text(
            "Letters guessed:",
            fontSize = 22.sp,
            fontFamily = FontFamily.Serif,
            fontWeight = FontWeight.Bold
        )
    }

    Spacer(modifier = Modifier.height(20.dp))

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        guessed.forEach { char ->
            Text(
                "$char ",
                fontSize = 36.sp,
                fontFamily = FontFamily.Serif,
                fontWeight = FontWeight.Bold,
                lineHeight = 44.sp,
                color = if (char in secretWord) Color(0xFF668137) else Color(0xFFAB3333)
            )
        }
    }
}