package com.example.plank.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.plank.components.Lives

@Composable
fun GameScreen() {
    Box(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.fillMaxSize().padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally) {
            Lives(
                livesRemaining = 5, maxLives = 5
            )

            Spacer(modifier = Modifier.height(32.dp))


            Text(
                "Guess a letter to guess the word below. Beware: for every incorrect letter, you will lose a life!",
                fontSize = 24.sp,
            )
        }
    }

}
