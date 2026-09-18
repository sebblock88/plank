package com.example.plank

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.plank.screens.GameScreen
import com.example.plank.screens.Homescreen
import com.example.plank.screens.LoseScreen
import com.example.plank.screens.WinScreen

@Composable
fun App() {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "homescreen") {

        composable(route = "homescreen") {
            Homescreen(navController = navController)
        }

        composable(route = "gamescreen") {
            GameScreen(navController)
        }

        composable(route = "winscreen/{secretWord}") {
            WinScreen(
                secretWord = it.arguments?.getString("secretWord") ?: "",
                navController = navController
            )
        }

        composable(route = "losescreen/{secretWord}") {
            LoseScreen(
                secretWord = it.arguments?.getString("secretWord") ?: "",
                navController = navController
            )
        }
    }


}
