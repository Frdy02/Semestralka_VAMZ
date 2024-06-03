package com.example.semestralka_vamz.pull

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import com.example.semestralka_vamz.zaklad.Cvik
import com.example.semestralka_vamz.zaklad.SpodnaLista

/**
 * PredlaktieScreen je obrazovka, ktorá zobrazuje cvičenia na posilnenie predlaktia.
 *
 * @param navController NavController použitý na navigáciu medzi obrazovkami.
 */
@Composable
fun PredlaktieScreen(navController: NavController) {
    val cviky = remember {
        listOf(
            Cvik("Klopenie zápästia\ns veľkou činkou", R.drawable.predlaktie2,
                "1. Sadnite si na okraj lavice a uchopte činku nadhmatom na šírku ramien, predlaktie položte na stehná\n" +
                        "2. Ohnutím zápästia spustite činku dole k podlahe\n" +
                        "3. Zdvihnite činku hore pomocou pohybu zápästia"),

            Cvik("Zdvih s veľkou\nčinkou nadhmatom", R.drawable.predlaktie1,
                "1.Uchopte čitku nadhmatom na šírku ramien a s natiahnutými rukami\n" +
                        "2. Zdvihnite činku na úroveň ramien klopením zápästia hore a dole pri ohýbaní lakťov\n" +
                        "3. Spustite činku späť do východiskovej polohy, povoľte zápästie"),
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
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable { cvik.isExpanded.value = !cvik.isExpanded.value },
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
                                    painter = painterResource(id = cvik.imageResId),
                                    contentDescription = null,
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(10.dp)
                                        .height(300.dp)
                                )
                                Text(
                                    text = cvik.popis,
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


