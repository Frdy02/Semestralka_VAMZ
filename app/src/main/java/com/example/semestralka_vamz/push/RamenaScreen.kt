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
import com.example.semestralka_vamz.zaklad.Cviky
import com.example.semestralka_vamz.zaklad.SpodnaLista
import com.example.semestralka_vamz.zaklad.createAnnotatedString


@Composable
fun RamenaScreen(navController: NavController) {
    val cviky = remember {
        listOf(
            Cviky(
                "Predná hlava",
                R.drawable.predna1,
                createAnnotatedString(
                    "Tlaky na ramená s jednoručkami:\n",
                    "1. V sede na lavičke uchopte jednoručky dlaňami dopredu na šírku ramien\n" +
                            "2. Jednoručky zdvíhajte vertikálne hore až do polohy napnutých lakťov\n" +
                            "3. Jednoručky spúštajte späť až do východiskovej polohy"
                ),
                R.drawable.predna2,
                createAnnotatedString(
                    "Predpažovanie s kladkou:\n",
                    "1. Jednou rukou s dlaňou smerom dole uchopte držadlo pripevnené k spodnej kladke\n" +
                            "2. Chbtom ku kladkovému zariadeniu zdvihnite držadlo oblúkom hore až na úroveň ramien s napnutým lakťom\n" +
                            "3. Držadlo spustite späť do východiskovej polohy"
                )
            ),
            Cviky(
                "Stredná hlava",
                R.drawable.stredne_r1,
                createAnnotatedString(
                    "Upažovanie s jednoručkami v stoji:\n",
                    "1. Uchopte jednoručky vo vzpriamenom stoji, ruky majte spustené dole\n" +
                            "2. Zdvihnite ruky po stranách hore až na úroveň ramien\n" +
                            "3. Jednoručky spúšťajte späť do východiskovej polohy"
                ),
                R.drawable.stredne_r2,
                createAnnotatedString(
                    "Upažovanie s kladkou v stoji:\n",
                    "1. Jednou rukou uchopte držadlo pripevnené k spodnej kladke\n" +
                            "2. Zdvíhajte ruku oblúkom do strany a hore až na úroveň ramien, lakeť majte napnutý\n" +
                            "3. Spúštajte držadlo späť do východiskovej polohy k pásu"
                )
            ),
            Cviky(
                "Zadná hlava",
                R.drawable.zadna1,
                createAnnotatedString(
                    "Rozpažovanie na stroji:\n",
                    "1. V sede čelom k stroju s hrudníkom opretým o chrbtovú podložku stroja uchopte držadlá vpredu s rukami natiahnutými na úroveň ramien\n" +
                            "2. Držadlá ťahajte oblúkom čo najviac dozadu, lakte držte vysoko a ruky paralelne s podlahou\n" +
                            "3. Vráťte držadlá späť do východiskovej pozície dopredu"
                ),
                R.drawable.zadna2,
                createAnnotatedString(
                    "Upažovanie s jednoručkami v predklone:\n",
                    "1. Uchopte dve jednoručky, ruky majte spustené dole a predkloňte sa v páse dopredu tak, aby chrbtica bola rovná a hlava smerovala hore\n" +
                            "2. S dlaňami k sebe zdvihnite jednoručky na úroveň uší, lakte majte ľahko ohnuté\n" +
                            "3. Spúštajte jednoručky späť do východiskovej pozície"
                )
            )
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
                                    painter = painterResource(id = cvik.imageResId1),
                                    contentDescription = null,
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(10.dp)
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
                                        .padding(10.dp)
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


