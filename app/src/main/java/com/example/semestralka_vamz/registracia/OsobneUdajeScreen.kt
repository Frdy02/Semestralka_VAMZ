package com.example.semestralka_vamz.registracia

import android.content.SharedPreferences
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun OsobneUdajeScreen(onNext: () -> Unit, sharedPreferences: SharedPreferences) {
    var meno by remember { mutableStateOf("") }
    var vyska by remember { mutableStateOf("") }
    var hmotnost by remember { mutableStateOf("") }
    var vek by remember { mutableStateOf("") }
    var pohlavie by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField(
            value = meno,
            onValueChange = { meno = it },
            label = { Text("Meno") }
        )
        TextField(
            value = vyska,
            onValueChange = { vyska = it },
            label = { Text("Výška (cm)") },
        )
        TextField(
            value = hmotnost,
            onValueChange = { hmotnost = it },
            label = { Text("Hmotnosť (kg)") },
        )
        TextField(
            value = vek,
            onValueChange = { vek = it },
            label = { Text("Vek") },
        )
        TextField(
            value = pohlavie,
            onValueChange = { pohlavie = it },
            label = { Text("Pohlavie") }
        )
        Button(
            onClick = {
                sharedPreferences.edit().putString("meno", meno).apply()
                sharedPreferences.edit().putString("vyska", vyska).apply()
                sharedPreferences.edit().putString("hmotnost", hmotnost).apply()
                sharedPreferences.edit().putString("vek", vek).apply()
                onNext()
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Ďalej")
        }
    }
}