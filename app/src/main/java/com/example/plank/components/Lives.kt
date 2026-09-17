package com.example.plank.components

import android.R.attr.padding
import com.example.plank.R
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Lives(livesRemaining: Int, maxLives: Int) {
    Row(modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.Top) {
        Image(
            painter = painterResource(id = R.drawable.plank_logo),
            contentDescription = "Plank Logo",
            modifier = Modifier
                .width(120.dp)
                .wrapContentHeight(),
            contentScale = ContentScale.Fit
        )
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(6.dp),
            modifier = Modifier.padding(top = 10.dp)
        ) {
            Text(
                "Lives:",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = "❤️".repeat(livesRemaining) + "🖤".repeat(maxLives - livesRemaining),
                fontSize = 18.sp
            )
//            Text(
//                text = "☠️".repeat(livesRemaining) + "🪦️".repeat(maxLives - livesRemaining),
//                fontSize = 18.sp
//            )
        }
    }
}

