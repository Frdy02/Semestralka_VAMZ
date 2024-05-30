package com.example.semestralka_vamz.zaklad

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.semestralka_vamz.R

@Composable
fun SpodnaLista(navController: NavController, modifier: Modifier = Modifier) {
    val backgroundColor = Color.DarkGray
    Surface(
        color = backgroundColor,
        modifier = modifier
            .fillMaxWidth()
            .height(70.dp)
            .padding(10.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.fillMaxWidth()
        ) {
            Image(
                painter = painterResource(R.drawable.cvik),
                contentDescription = "CvicenieScreen",
                modifier = Modifier
                    .size(70.dp)
                    .clickable { navController.navigate("CvicenieScreen") }
            )
            Image(
                painter = painterResource(R.drawable.house),
                contentDescription = "HomeScreen",
                modifier = Modifier
                    .size(70.dp)
                    .clickable { navController.navigate("HomeScreen") }
            )
        }
    }
}



