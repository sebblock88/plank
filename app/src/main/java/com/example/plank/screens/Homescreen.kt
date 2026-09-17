package com.example.plank.screens

import androidx.compose.foundation.Image
import com.example.plank.R
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Button
import androidx.compose.material3.Surface

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.plank.components.WoodenPlaySign

@Composable
fun Homescreen(navController: NavController) {
    Surface(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.background_homescreen),
            contentDescription = "background",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        Column(modifier = Modifier.fillMaxSize().padding(24.dp),
            verticalArrangement = Arrangement.spacedBy(32.dp, Alignment.CenterVertically),
            horizontalAlignment = Alignment.CenterHorizontally) {
            Image(
                painter = painterResource(id = R.drawable.plank_logo),
                contentDescription = "plank_logo",
                modifier = Modifier.fillMaxWidth(0.95f).wrapContentHeight().padding(bottom = 16.dp),
                contentScale = ContentScale.Fit
            )
//            Text(
//                text = "PLANK",
//                fontSize = 50.sp,
//                fontWeight = FontWeight.Medium,
//                textAlign = TextAlign.Center,
//                color = Color.Red
//            )
//            Text(
//                text = "Every letter counts",
//                fontSize = 25.sp,
//                fontWeight = FontWeight.Medium,
//                textAlign = TextAlign.Center,
//                color = Color.Red
//            )

//            Spacer(modifier = Modifier.height(28.dp))

            WoodenPlaySign(navController = navController, destinationRoute = "gamescreen")

//            Button( onClick = {navController.navigate("gamescreen")}) {
//                Text(
//                    text = "Play Game"
//                )
            }
        }
    }
