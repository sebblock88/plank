package com.example.plank.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.plank.components.GuessBox
import com.example.plank.components.GuessedLettersBox
import com.example.plank.components.Lives
import com.example.plank.components.SecretWord

@Composable
fun GameScreen() {
    var guessed by remember { mutableStateOf(setOf<Char>()) }

    val secretWord = "treasure".uppercase()
    val win = secretWord.all { it in guessed }
    val maxLives = 5
    val incorrectGuess = guessed.count { it !in secretWord }
    val livesRemaining = (maxLives - incorrectGuess)
    val lose = livesRemaining <= 0

    fun resetGame() {
        guessed = emptySet()
    }

    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier.fillMaxSize().padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Lives(
                livesRemaining = livesRemaining,
                maxLives = maxLives,
            )

            Spacer(modifier = Modifier.height(60.dp))

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxWidth().padding(16.dp)
            ) {
                Text(
                    "Guess a letter to reveal the word",
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    "Every wrong guess costs 1 life! ☠️",
                    fontSize = 18.sp,
                    color = Color.DarkGray
                )
            }

            Spacer(modifier = Modifier.height(44.dp))

            SecretWord(secretWord = secretWord, guessed = guessed)

            Spacer(modifier = Modifier.height(44.dp))

            GuessBox(onLettersEntered = { char -> guessed = guessed + char })

            Spacer(modifier = Modifier.height(44.dp))

            GuessedLettersBox(guessed = guessed)

            if (win || lose) {
                AlertDialog(
                    onDismissRequest = {},
                    containerColor = Color(0xFF1E1E1E),
                    title = {
                        Text(text = if (win) "VICTORY! 🏴‍☠️" else "GAME OVER! 🪦️",
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White,
                            textAlign = TextAlign.Center,
                            modifier = Modifier.fillMaxWidth())
                },
                    text = {
                        Text(
                            text = if (win)
                                "Ahoy! Back to deck shipmate!"
                            else
                                "Walk the plank!\n\nThe word was: $secretWord",
                            fontSize = 16.sp,
                            color = Color.LightGray,
                            textAlign = TextAlign.Center,
                            modifier = Modifier.fillMaxWidth()
                        )
                    },
                    confirmButton = {
                    Button(onClick = {resetGame()},
                        modifier = Modifier.fillMaxWidth(),
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF2196F3))) {
                        Text("Play again",
                            fontWeight = FontWeight.Bold)
                    }
                })
            }
        }
    }
}



