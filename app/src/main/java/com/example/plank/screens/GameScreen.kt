package com.example.plank.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
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
                incorrectGuesses = incorrectGuess
            )

            Spacer(modifier = Modifier.height(60.dp))


            Text(
                "Guess a letter to guess the word below. Beware: for every incorrect letter, you will lose a life!",
                fontSize = 24.sp,
            )

            Spacer(modifier = Modifier.height(44.dp))

            SecretWord(secretWord = secretWord, guessed = guessed)

            Spacer(modifier = Modifier.height(44.dp))

            GuessBox(onLettersEntered = { char -> guessed = guessed + char })

            Spacer(modifier = Modifier.height(44.dp))

            GuessedLettersBox(guessed = guessed)

            if (win || lose) {
                AlertDialog(onDismissRequest = {}, title = {
                    Text(text = if (win) "Back to deck shipmate!" else "Walk the Plank!")
                }, confirmButton = {
                    Button(onClick = {resetGame()}) {
                        Text("Play again")
                    }
                })
            }
        }
    }
}



