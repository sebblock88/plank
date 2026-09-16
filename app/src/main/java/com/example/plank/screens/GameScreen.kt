package com.example.plank.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.plank.components.Lives
import com.example.plank.components.SecretWord

@Composable
fun GameScreen() {
    var guessed by remember { mutableStateOf(setOf<Char>()) }

    Box(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.fillMaxSize().padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally) {
            Lives(
                livesRemaining = 5, maxLives = 5
            )

            Spacer(modifier = Modifier.height(60.dp))


            Text(
                "Guess a letter to guess the word below. Beware: for every incorrect letter, you will lose a life!",
                fontSize = 24.sp,
            )

            Spacer(modifier = Modifier.height(44.dp))

            SecretWord("flag", guessed = guessed)

            Spacer(modifier = Modifier.height(44.dp))

            }
        }
    }

}
