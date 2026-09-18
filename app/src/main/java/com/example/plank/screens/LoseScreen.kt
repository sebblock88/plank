package com.example.plank.screens

import android.R.attr.top
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.plank.R
import com.example.plank.components.PlayAgain
import com.example.plank.components.WoodenPlaySign

@Composable
fun LoseScreen(
    secretWord: String,
    navController: NavHostController
) {

    val textDark = Color(0xFF3B2F1B)

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {

        Image(
            painter = painterResource(id = R.drawable.lose_screen_background),
            contentDescription = "Lose Background",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(32.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {


            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(top = 80.dp)
            ) {

                Spacer(modifier = Modifier.height(60.dp))

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(320.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.overboard),
                        contentDescription = null,
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.Crop
                    )

                    Text(
                        "The word was:",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        fontFamily = FontFamily.Serif,
                        color = textDark,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(top = 70.dp)
                    )

                    Text(
                        text = secretWord.uppercase().toCharArray().joinToString(" "),
                        fontSize = 26.sp,
                        fontWeight = FontWeight.Bold,
                        fontFamily = FontFamily.Serif,
                        color = textDark,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(top = 125.dp)
                    )
                }
            }
        }

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .padding(bottom = 24.dp)
                    .fillMaxWidth()
                    .fillMaxHeight()
            ) {

                Spacer(modifier = Modifier.weight(3f))

                PlayAgain(navController = navController, destinationRoute = "gamescreen")

                Spacer(modifier = Modifier.height(40.dp))

                Text(
                    text = "\"Not every journey ends in treasure...\"",
                    fontSize = 16.sp,
                    fontFamily = FontFamily.Serif,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    fontStyle = androidx.compose.ui.text.font.FontStyle.Italic,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .padding(top = 8.dp)
                        .padding(horizontal = 32.dp)
                        .widthIn(max = 280.dp)
                )

                Spacer(modifier = Modifier.weight(1f))
            }
        }
    }
