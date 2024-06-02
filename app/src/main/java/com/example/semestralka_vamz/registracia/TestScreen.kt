package com.example.semestralka_vamz.registracia

import android.content.SharedPreferences
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TestScreen(onNext: () -> Unit, sharedPreferences: SharedPreferences) {
    var klik by remember { mutableStateOf("") }
    var drep by remember { mutableStateOf("") }
    var behTime by remember { mutableStateOf("") }
    var bench by remember { mutableStateOf("") }
    var zdvyh by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Úvodné testy",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(16.dp))

        TextField(
            value = klik,
            onValueChange = { klik = it },
            label = { Text("Počet klikov za 1 minútu") },
        )

        Spacer(modifier = Modifier.height(16.dp))

        TextField(
            value = drep,
            onValueChange = { drep = it },
            label = { Text("Počet drepov za 1 minútu") },
        )

        Spacer(modifier = Modifier.height(16.dp))

        TextField(
            value = behTime,
            onValueChange = { behTime = it },
            label = { Text("Čas behu na 1 km (v minútach)") },
        )

        Spacer(modifier = Modifier.height(16.dp))

        TextField(
            value = bench,
            onValueChange = { bench = it },
            label = { Text("Max bench presse (kg)") },
        )

        Spacer(modifier = Modifier.height(16.dp))

        TextField(
            value = zdvyh,
            onValueChange = { zdvyh = it },
            label = { Text("Počet zhybov na hrazde ") },
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                with(sharedPreferences.edit()) {
                    putString("Počet klikov", klik)
                    putString("Počet drepov", drep)
                    putString("Čas behu", behTime)
                    putString("PR Bench press", bench)
                    putString("Počet zhybov", zdvyh)
                    apply()
                }
                onNext()
            },
        ) {
            Text("Dokončiť")
        }
    }
}