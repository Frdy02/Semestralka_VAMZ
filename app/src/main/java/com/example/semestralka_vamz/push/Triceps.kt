package com.example.semestralka_vamz.push

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
 * TricepsScreen je obrazovka, ktorá zobrazuje cvičenia na posilnenie tricepsov.
 *
 * @param navController NavController použitý na navigáciu medzi obrazovkami.
 */
@Composable
fun TricepsScreen(navController: NavController) {
    val cviky = remember {
        listOf(
            Cvik("Tricepsové sťahovanie kladky", R.drawable.triceps1,
                "1. Uchopte tyč pripevnenú k hornej kladbe nadhmatom na šírku ramien\n" +
                        "2. Cvik začnite s tyčou na úrovni hrudníka, lakte zvierajú uhol o trochu viac ako 90°\n" +
                        "3. Tyč sťahujte dole až do napnutia laktov, nadlaktie udržujte pri tele "),

            Cvik("Tricepsové kliky\nna bradlách", R.drawable.triceps2,
                "1. Uchopte tyče a zdvíhajte sa až do natiahnutých rúk\n" +
                        "2. Ohnite lakte a pomaly spúštajte telo, pokiaľ horné časti rúk nie sú paralelne s podlahou (trup majte stále rovno)\n" +
                        "3. Zdvihnite sa späť hore až do napnutia lakťov"),

            Cvik("Tricepsový zdvih\ns veľkou činkou", R.drawable.triceps3,
                "1. Vľahu na lavičke uchopte činku nad hrudníkom úzkym úchopom nadhmaton, ruky majte asi 15 cm od seba\n" +
                        "2. Ohnite lakte a spúštajte činku dole k čelu\n" +
                        "3. Zdvihnite činku hore až do napnutia lakťov")
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
