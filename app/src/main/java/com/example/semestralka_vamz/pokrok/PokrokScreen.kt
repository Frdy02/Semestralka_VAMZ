package com.example.semestralka_vamz.pokrok

import android.content.SharedPreferences
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.semestralka_vamz.zaklad.SpodnaLista
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

fun SharedPreferences.putTrainingRecords(records: List<TrainingRecord>) {
    val json = Gson().toJson(records)
    edit().putString("trainingRecords", json).apply()
}

fun SharedPreferences.getTrainingRecords(): List<TrainingRecord> {
    val json = getString("trainingRecords", null) ?: return emptyList()
    val type = object : TypeToken<List<TrainingRecord>>() {}.type
    return Gson().fromJson(json, type)
}

data class TrainingRecord(
    val datum: String,
    val hmotnost: String,
    val pocetOpakovani: String,
    val poznamka: String
)

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PokrokScreen(navController: NavController, sharedPreferences: SharedPreferences) {
    val meno = sharedPreferences.getString("meno", "Užívateľ") ?: "Užívateľ"
    var hmotnost by remember { mutableStateOf("") }
    var pocetOpakovani by remember { mutableStateOf("") }
    var poznamka by remember { mutableStateOf("") }
    val treningoveZaznamy = remember { mutableStateListOf<TrainingRecord>() }
    var showInitialTests by remember { mutableStateOf(false) }

    // Načítanie uložených záznamov pri spustení
    LaunchedEffect(Unit) {
        val savedRecords = sharedPreferences.getTrainingRecords()
        treningoveZaznamy.addAll(savedRecords)
    }

    fun removeRecord(record: TrainingRecord) {
        treningoveZaznamy.remove(record)
        sharedPreferences.putTrainingRecords(treningoveZaznamy)
    }

    Surface(
        color = Color(0xFF000015),
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(15.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                item {
                    Text(
                        text = "Ahoj, $meno!",
                        fontWeight = FontWeight.Bold,
                        fontSize = 30.sp,
                        color = Color.White,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth()
                    )
                }
                item {
                    Button(
                        onClick = { showInitialTests = !showInitialTests },
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(
                            text = "Počiatočné testy",
                            fontWeight = FontWeight.Bold,
                            fontSize = 19.sp,)
                    }
                    Spacer(modifier = Modifier.height(25.dp))
                }
                if (showInitialTests) {
                    item {
                        val initialTestsResults = """
                            Počet klikov: ${sharedPreferences.getString("Počet klikov", "Žiadne záznamy")}
                            Počet drepov: ${sharedPreferences.getString("Počet drepov", "Žiadne záznamy")}
                            Čas behu: ${sharedPreferences.getString("Čas behu", "Žiadne záznamy")}
                            PR Bench press: ${sharedPreferences.getString("PR Bench press", "Žiadne záznamy")}
                            Počet zhybov: ${sharedPreferences.getString("Počet zhybov", "Žiadne záznamy")}
                        """.trimIndent()
                        Text(
                            text = "Výsledky počiatočných testov:",
                            color = Color.White,
                            fontWeight = FontWeight.Bold,
                            fontSize = 20.sp,
                            modifier = Modifier.padding(10.dp))
                        Text(
                            text = initialTestsResults,
                            color = Color.White,
                            fontSize = 19.sp,
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                    }
                }
                item {
                    TextField(
                        value = hmotnost,
                        onValueChange = { hmotnost = it },
                        label = { Text("Hmotnosť (kg) / Vzdialenosť (km)", fontSize = 19.sp) },
                        modifier = Modifier.fillMaxWidth()
                    )
                }
                item {
                    Spacer(modifier = Modifier.height(16.dp))
                    TextField(
                        value = pocetOpakovani,
                        onValueChange = { pocetOpakovani = it },
                        label = { Text("Počet opakovaní / čas", fontSize = 19.sp) },
                        modifier = Modifier.fillMaxWidth()
                    )
                }
                item {
                    Spacer(modifier = Modifier.height(16.dp))
                    TextField(
                        value = poznamka,
                        onValueChange = { poznamka = it },
                        label = { Text("Poznámky", fontSize = 19.sp) },
                        modifier = Modifier.fillMaxWidth()
                    )
                }
                item {
                    Spacer(modifier = Modifier.height(16.dp))
                    Button(
                        onClick = {
                            val currentDateTime =
                                SimpleDateFormat("dd.MM.yyyy HH:mm", Locale.getDefault()).format(
                                    Date()
                                )

                            val novyZaznam = TrainingRecord(currentDateTime, hmotnost, pocetOpakovani, poznamka)
                            treningoveZaznamy.add(novyZaznam)
                            sharedPreferences.putTrainingRecords(treningoveZaznamy)
                            hmotnost = ""
                            pocetOpakovani = ""
                            poznamka = ""
                        },
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text("Pridať záznam",
                            fontWeight = FontWeight.Bold,
                            fontSize = 19.sp
                        )
                    }
                }
                items(treningoveZaznamy) { record ->
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp)
                            .combinedClickable(
                                onClick = { /* niečo do buducna */ },
                                onLongClick = { removeRecord(record) }
                            )
                    ) {
                        Column(
                            modifier = Modifier.padding(16.dp)
                        ) {
                            Text(text = "Dátum: ${record.datum}", fontWeight = FontWeight.Bold)
                            Text(text = "Hmotnosť: ${record.hmotnost} kg")
                            Text(text = "Počet opakovaní: ${record.pocetOpakovani}")
                            Text(text = "Poznámky: ${record.poznamka}")
                        }
                    }
                }
            }
            SpodnaLista(navController = navController)
        }
    }
}




