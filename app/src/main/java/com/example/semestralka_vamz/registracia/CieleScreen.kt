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
fun CieleScreen(onNext: () -> Unit) {
    val goals = listOf("Chudnutie", "Naberanie svalovej hmoty", "Udržanie kondície")
    var selectedGoal by remember { mutableStateOf(goals[0]) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Stanovte si cieľ",
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold)

        Spacer(modifier = Modifier.height(16.dp))

        goals.forEach { goal ->
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                RadioButton(
                    selected = (goal == selectedGoal),
                    onClick = { selectedGoal = goal }
                )
                Text(text = goal)
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