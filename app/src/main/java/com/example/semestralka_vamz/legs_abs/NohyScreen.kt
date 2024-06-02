package com.example.semestralka_vamz.legs_abs

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.semestralka_vamz.R
import com.example.semestralka_vamz.zaklad.Cviky
import com.example.semestralka_vamz.zaklad.SpodnaLista
import com.example.semestralka_vamz.zaklad.createAnnotatedString

@Composable
fun NohyScreen(navController: NavController) {
    val cviky = remember {
        listOf(
            Cviky(
                "Kvadricepsy",
                R.drawable.predkopavanie,
                createAnnotatedString(
                "Predkopávanie v sede na stroji: \n",
                    "1. V sede na stroji zaprieme priehlavky o valčeky stroja\n" +
                        "2. Nohy zdvíhajte hore až do napnutých kolien\n" +
                        "3. Nohy spúštajte späť do východiskovej polohy, kolená zvierajú 90° uhol"
                ),
                R.drawable.legpress,
                createAnnotatedString(
                "Leg-press: \n",
                    "1. V sede na stroji umiestnite chodidlá v šírke ramien na opierku stroja\n" +
                        "2. Pomaly spúštajte závažie dole kým budú kolená v  pravom uhle\n" +
                        "3. Závažie tlačte späť do východiskovej polohy vystretých nôh"
                )
            ),

            Cviky("Hamstringy",
                R.drawable.zakopavanie,
                createAnnotatedString(
                "Zakopávanie na lavičke \n",
                    "1. Ľahnite si čelom smerom dole na lavičku a zaprite päty o valčeky stroja\n" +
                        "2. Priťahovaním päty smerom k sedacím svalom a ohýbaním v kolenách zdvíhajte závažie\n" +
                        "3. Vráťte závažie späť do východiskovej pozície"
                ),
                R.drawable.mrtvy,
                createAnnotatedString(
                "Mrtvý ťah na nohy: \n",
                    "1. V pozícii postojačky s chodidlami na šírku bokov uchopte činku do natiahnutých rúk\n" +
                        "2. Predkloňte sa v páse a spustite činku dole, nohy neobýbajte\n" +
                        "3. Pohyb zastavte tesne nad zemou a zdvihnite činku späť"
                )
            ),

            Cviky("Lítka",
                R.drawable.litka1,
                createAnnotatedString(
                "Výpony na stroji v stoji: \n",
                    "1. Prednú časť chodidiel umiestnite na plošinu, ramená pod podložky stroja a spustite päty čo najnižšie\n" +
                        "2. Zdvihnutím päty čo najvyššie posuňte závažiš hore, nohy majte stále napnuté\n" +
                        "3. Pomaly spúštajte päty späť do východiskovej polohy"
                ),
                R.drawable.litka2,
                createAnnotatedString(
                "Výpony v sede: \n",
                    "1. Prednú časť chodidiel postavte na plošinu, položte opierky stroja na spodnú časť stehien a spustite päty čo najnižšie\n" +
                        "2. Zdvihnutím päty čo najvyššie posuniete závažie hore\n" +
                        "3. Pomalým pohybom vracajte päty do východiskovej polohy"
                )
            ),
        )
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
                    .padding(5.dp),
                verticalArrangement = Arrangement.spacedBy(50.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                items(cviky) { cvik ->
                    Card(
                        shape = RoundedCornerShape(10.dp),
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable { cvik.isExpanded.value = !cvik.isExpanded.value }
                    ) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp)
                        ) {
                            Text(
                                text = cvik.nazov,
                                fontWeight = FontWeight.Bold,
                                textAlign = TextAlign.Center,
                                fontSize = 25.sp,
                                color = Color.White,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(8.dp)
                                    .background(Color.DarkGray)
                            )
                            if (cvik.isExpanded.value) {
                                Image(
                                    painter = painterResource(id = cvik.imageResId1),
                                    contentDescription = null,
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(8.dp)
                                        .height(300.dp)
                                )
                                Text(
                                    text = cvik.popis1,
                                    fontWeight = FontWeight.Normal,
                                    fontSize = 18.sp,
                                    color = Color.White,
                                    modifier = Modifier.padding(10.dp)
                                )
                                Image(
                                    painter = painterResource(id = cvik.imageResId2),
                                    contentDescription = null,
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(8.dp)
                                        .height(300.dp)
                                )
                                Text(
                                    text = cvik.popis2,
                                    fontWeight = FontWeight.Normal,
                                    fontSize = 18.sp,
                                    color = Color.White,
                                    modifier = Modifier.padding(10.dp)
                                )
                            }
                        }
                    }
                }
            }
            SpodnaLista(navController = navController)
        }
    }
}


