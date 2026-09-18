package com.example.plank.screens

import android.R.attr.top
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
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
fun WinScreen(
    secretWord: String,
    navController: NavHostController
) {

    val textDark = Color(0xFF3B2F1B)

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {

        Image(
            painter = painterResource(id = R.drawable.win_screen_background),
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
                modifier = Modifier.padding(top = 24.dp)
            ) {

                Spacer(modifier = Modifier.height(100.dp))

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(330.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.you_escaped),
                        contentDescription = null,
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.Crop
                    )

                    Text(
                        text = secretWord.uppercase().toCharArray().joinToString(" "),
                        fontSize = 26.sp,
                        fontWeight = FontWeight.Bold,
                        fontFamily = FontFamily.Serif,
                        color = textDark,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(top = 60.dp)
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
                text = "\"Every letter counts\"",
                fontSize = 16.sp,
                fontFamily = FontFamily.Serif,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                fontStyle = androidx.compose.ui.text.font.FontStyle.Italic,
                modifier = Modifier.offset(y = 60.dp)
            )

            Spacer(modifier = Modifier.weight(1f))
        }
    }
}
