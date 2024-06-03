package com.example.semestralka_vamz.registracia

import android.content.SharedPreferences
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp


/**
 * OsobneUdajeScreen je obrazovka, kde užívateľ zadáva svoje osobné údaje.
 * Používa sa tu RegistraciaVieWModel, kvoli otočeniu obrazovky
 *
 *
 * @param onNext Funkcia, ktorá sa spustí po kliknutí na tlačidlo Ďalej.
 * @param sharedPreferences Zdieľané preferencie na uloženie osobných údajov.
 * @param viewModel ViewModel, ktorý udržiava stav osobných údajov.
 */
@Composable
fun OsobneUdajeScreen(onNext: () -> Unit, sharedPreferences: SharedPreferences, viewModel: RegistraciaViewModel) {
    val meno by viewModel.meno.collectAsState()
    val vyska by viewModel.vyska.collectAsState()
    val hmotnost by viewModel.hmotnost.collectAsState()
    val vek by viewModel.vek.collectAsState()
    val pohlavie by viewModel.pohlavie.collectAsState()

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {
            TextField(
                value = meno,
                onValueChange = { viewModel.onMenoChange(it) },
                label = { Text("Meno") }
            )
        }
        item {
            TextField(
                value = vyska,
                onValueChange = { viewModel.onVyskaChange(it) },
                label = { Text("Výška (cm)") },
                keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number)
            )
        }
        item {
            TextField(
                value = hmotnost,
                onValueChange = { viewModel.onHmotnostChange(it) },
                label = { Text("Hmotnosť (kg)") },
                keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number)
            )
        }
        item {
            TextField(
                value = vek,
                onValueChange = { viewModel.onVekChange(it) },
                label = { Text("Vek") },
                keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number)
            )
        }
        item {
            TextField(
                value = pohlavie,
                onValueChange = { viewModel.onPohlavieChange(it) },
                label = { Text("Pohlavie") }
            )
        }
        item {
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
}