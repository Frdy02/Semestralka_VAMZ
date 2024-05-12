package com.example.semestralka_vamz

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun Legs_Abs_Screen(navController: NavController) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color(0xFF000015), // Tmavomodré pozadie
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(50.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(
                onClick = { /* Do something when the button is clicked */ },
                modifier = Modifier.padding(50.dp).fillMaxWidth()
            ) {
                Text(
                    text = "Predné stehná",
                    fontWeight = FontWeight.Bold,
                    fontSize = 30.sp
                )
            }

            Button(
                onClick = { /* Do something when the button is clicked */ },
                modifier = Modifier.padding(50.dp).fillMaxWidth()
            ) {
                Text(
                    text = "Zadné stehná",
                    fontWeight = FontWeight.Bold,
                    fontSize = 30.sp
                )
            }
        }
    }
}