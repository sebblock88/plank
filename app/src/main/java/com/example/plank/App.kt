package com.example.plank

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.plank.screens.GameScreen
import com.example.plank.screens.Homescreen

@Composable
fun App() {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "homescreen") {

        composable(route = "homescreen") {
            Homescreen(navController = navController)
        }

        composable(route = "gamescreen") {
            GameScreen()
        }
    }
}
