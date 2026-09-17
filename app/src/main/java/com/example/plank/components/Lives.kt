package com.example.plank.components

import android.R.attr.padding
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.unit.sp

@Composable
fun Lives(livesRemaining: Int, maxLives: Int, incorrectGuesses: Int) {
    Row(modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween) {
        Text(
            "Plank",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
        Column(horizontalAlignment = Alignment.End) {
            Text(
                "Lives remaining",
                fontSize = 20.sp
            )
            Text(
                text = "☠️".repeat(livesRemaining) + "🪦️".repeat(maxLives - livesRemaining),
                fontSize = 20.sp
            )
//            Text(
//                text = "Incorrect guesses",
//                fontSize = 20.sp
//            )
//            Text(
//                text = "🪦".repeat(incorrectGuesses),
//                fontSize = 20.sp
//            )
        }
    }
}

