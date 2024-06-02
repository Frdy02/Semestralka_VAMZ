package com.example.semestralka_vamz.registracia

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun FitnessScreen(onNext: () -> Unit) {
    val levels = listOf("Začiatočník", "Pokročilý", "Expert")
    var selectedLevel by remember { mutableStateOf(levels[0]) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Vyberte úroveň kondície",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold)

        Spacer(modifier = Modifier.height(16.dp))

        levels.forEach { level ->
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                RadioButton(
                    selected = (level == selectedLevel),
                    onClick = { selectedLevel = level }
                )
                Text(text = level)
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = onNext
        ) {
            Text("Ďalej")
        }
    }
}