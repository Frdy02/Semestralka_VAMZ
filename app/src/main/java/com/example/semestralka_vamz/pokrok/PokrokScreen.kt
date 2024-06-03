package com.example.semestralka_vamz.pokrok

import android.content.SharedPreferences
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.semestralka_vamz.R
import com.example.semestralka_vamz.notifikacia.NotifikacnyPomocnik
import com.example.semestralka_vamz.zaklad.SpodnaLista
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

/**
 * Rozšírenie pre SharedPreferences na ukladanie a načítanie zoznamu tréningových záznamov.
 */
fun SharedPreferences.putTrainingRecords(records: List<TreningovyZaznam>) {
    val json = Gson().toJson(records)
    edit().putString("treningoveZaznamy", json).apply()
}

fun SharedPreferences.getTrainingRecords(): List<TreningovyZaznam> {
    val json = getString("treningoveZaznamy", null) ?: return emptyList()
    val type = object : TypeToken<List<TreningovyZaznam>>() {}.type
    return Gson().fromJson(json, type)
}


/**
 * PokrokScreen je obrazovka, kde užívateľ môže sledovať svoj tréningový pokrok,
 * pridávať nové tréningové záznamy a prezerať si predchádzajúce záznamy.
 *
 * @param navController NavController použitý na navigáciu medzi obrazovkami.
 * @param sharedPreferences Zdieľané preferencie na uloženie a načítanie tréningových záznamov.
 * @param viewModel ViewModel, ktorý udržiava stav obrazovky pokroku.
 */
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PokrokScreen(navController: NavController, sharedPreferences: SharedPreferences, viewModel: PokrokViewModel) {
    val meno = sharedPreferences.getString("meno", "Užívateľ") ?: "Užívateľ"
    val hmotnost by viewModel.hmotnost.collectAsState()
    val pocetOpakovani by viewModel.pocetOpakovani.collectAsState()
    val poznamka by viewModel.poznamka.collectAsState()
    val treningoveZaznamy by viewModel.treningoveZaznamy.collectAsState()
    var ukazVstupnyTest by remember { mutableStateOf(false) }
    var showValidationError by remember { mutableStateOf(false) }

    // Načítanie uložených záznamov pri spustení
    LaunchedEffect(Unit) {
        val savedRecords = sharedPreferences.getTrainingRecords()
        viewModel.loadRecords(savedRecords)
    }

    Surface(
        color = colorResource(id = R.color.background_color),
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
                        onClick = { ukazVstupnyTest = !ukazVstupnyTest },
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(
                            text = "Počiatočné testy",
                            fontWeight = FontWeight.Bold,
                            fontSize = 19.sp,)
                    }
                    Spacer(modifier = Modifier.height(25.dp))
                }
                if (ukazVstupnyTest) {
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
                        onValueChange = { viewModel.onHmotnostChange(it) },
                        label = { Text("Hmotnosť (kg) / Vzdialenosť (km)", fontSize = 19.sp) },
                        modifier = Modifier.fillMaxWidth(),
                        keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number)
                    )
                }
                item {
                    Spacer(modifier = Modifier.height(16.dp))
                    TextField(
                        value = pocetOpakovani,
                        onValueChange = { viewModel.onPocetOpakovaniChange(it) },
                        label = { Text("Počet opakovaní / čas", fontSize = 19.sp) },
                        modifier = Modifier.fillMaxWidth(),
                        keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number)
                    )
                }
                item {
                    Spacer(modifier = Modifier.height(16.dp))
                    TextField(
                        value = poznamka,
                        onValueChange = { viewModel.onPoznamkaChange(it) },
                        label = { Text("Poznámky", fontSize = 19.sp) },
                        modifier = Modifier.fillMaxWidth()
                    )
                }
                if (showValidationError) {
                    item {
                        Text(
                            text = "Všetky polia musia byť vyplnené!",
                            color = Color.Red,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(8.dp)
                        )
                    }
                }
                item {
                    Spacer(modifier = Modifier.height(16.dp))
                    Button(
                        onClick = {
                            if (hmotnost.isBlank() || pocetOpakovani.isBlank() || poznamka.isBlank()) {
                                showValidationError = true
                            } else {
                                showValidationError = false
                                val currentDateTime =
                                    SimpleDateFormat("dd.MM.yyyy HH:mm", Locale.getDefault()).format(
                                        Date()
                                    )

                                val novyZaznam = TreningovyZaznam(currentDateTime, hmotnost, pocetOpakovani, poznamka)
                                viewModel.addTrainingRecord(novyZaznam)
                                sharedPreferences.putTrainingRecords(viewModel.treningoveZaznamy.value)
                                viewModel.onHmotnostChange("")
                                viewModel.onPocetOpakovaniChange("")
                                viewModel.onPoznamkaChange("")
                                NotifikacnyPomocnik.posliNotifikaciu(
                                    navController.context,
                                    "Záznam uložený",
                                    "Váš tréningový záznam bol úspešne uložený."
                                )
                            }
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
                                onLongClick = {
                                    viewModel.removeTrainingRecord(record)
                                    sharedPreferences.putTrainingRecords(viewModel.treningoveZaznamy.value)
                                }
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




