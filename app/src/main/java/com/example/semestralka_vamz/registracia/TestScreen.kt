package com.example.semestralka_vamz.registracia

import android.content.SharedPreferences
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**
 * TestScreen je obrazovka, kde užívateľ vykonáva úvodné testy.
 *
 * @param onNext Funkcia, ktorá sa spustí po kliknutí na tlačidlo Dokončiť.
 * @param sharedPreferences Zdieľané preferencie na uloženie výsledkov testov.
 * @param viewModel ViewModel, ktorý udržiava stav testov.
 */
@Composable
fun TestScreen(onNext: () -> Unit, sharedPreferences: SharedPreferences, viewModel: RegistraciaViewModel) {
    val klik by viewModel.klik.collectAsState()
    val drep by viewModel.drep.collectAsState()
    val behTime by viewModel.behTime.collectAsState()
    val bench by viewModel.bench.collectAsState()
    val zdvyh by viewModel.zdvyh.collectAsState()

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            Text(
                text = "Úvodné testy",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
        }

        item {
            TextField(
                value = klik,
                onValueChange = { viewModel.onKlikChange(it) },
                label = { Text("Počet klikov za 1 minútu") },
                keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number)
            )
        }

        item {
            TextField(
                value = drep,
                onValueChange = { viewModel.onDrepChange(it) },
                label = { Text("Počet drepov za 1 minútu") },
                keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number)
            )
        }

        item {
            TextField(
                value = behTime,
                onValueChange = { viewModel.onBehTimeChange(it) },
                label = { Text("Čas behu na 1 km (v minútach)") },
                keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number)
            )
        }

        item {
            TextField(
                value = bench,
                onValueChange = { viewModel.onBenchChange(it) },
                label = { Text("Max bench press (kg)") },
                keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number)
            )
        }

        item {
            TextField(
                value = zdvyh,
                onValueChange = { viewModel.onZdvyhChange(it) },
                label = { Text("Počet zhybov na hrazde") },
                keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number)
            )
        }

        item {
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
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Dokončiť")
            }
        }
    }
}