package com.example.semestralka_vamz


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import androidx.compose.material3.Button
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun HomeScreen(navController: NavController) {
    val customColor = Color(0xFF001122)
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = customColor, // Tmavomodré pozadie
    ) {
        Column(
            modifier = Modifier.fillMaxSize().padding(50.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally)
        {
            Button(
                onClick = { /* Handle Push button click */ },
                modifier = Modifier.padding(50.dp).fillMaxWidth()
            ) {
                Text(
                    text = "Push",
                    fontWeight = FontWeight.Bold,
                    fontSize = 30.sp
                )
            }

            Button(
                onClick = { /* Handle Pull button click */ },
                modifier = Modifier.padding(50.dp).fillMaxWidth()
            ) {
                Text(
                    text = "Pull",
                    fontWeight = FontWeight.Bold,
                    fontSize = 30.sp
                )
            }

            Button(
                onClick = { /* Handle Leg + Abs button click */ },
                modifier = Modifier.padding(50.dp).fillMaxWidth()
            ) {
                Text(
                    text = "Leg + Abs",
                    fontWeight = FontWeight.Bold,
                    fontSize = 30.sp
                )
            }
        }
    }
}
