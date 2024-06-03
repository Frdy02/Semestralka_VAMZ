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
 * BicepsScreen je obrazovka, ktorá zobrazuje cvičenia na posilnenie bicepsov.
 *
 * @param navController NavController použitý na navigáciu medzi obrazovkami.
 */
@Composable
fun BicepsScreen(navController: NavController) {
    val cviky = remember {
        listOf(
            Cvik("Kladivový zdvih\ns jednoručkami", R.drawable.biceps1,
                "1. Do každej ruky uchopte jednoručku dlaňami smerom dovnútra a palcami dopreu\n" +
                        "2. Zdvihnite jednu činku k ramenu s dlaňami stále dovnútra\n" +
                        "3. Spustite jednoručku do východiskovej polohy a cvik opakujte s druhou rukou"),

            Cvik("Zdvih spodnej kladky v stoji", R.drawable.biceps2,
                "1. S natiahnutými rukami uchopte podhmatom tyč pripevnenú k spodnej kladke\n" +
                        "2. Tyč zdvihneme k ramenám a ohýbajte pritom lakte\n" +
                        "3. Pomaly tyč spúštajte až kým budú ruky natiahnuté (východisková pozícia)"),

            Cvik("Bicepsový zdvih\nna Scottovej lavičke", R.drawable.biceps3,
                "1. V sede na lavičke položte natiahnuté ruky na opierku a uchopte činku podhmatom na šírku ramien\n" +
                        "2. Zdvihnite činku hore k ramenám\n" +
                        "3. Vráte činku späť do východiskovej pozície"),
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
