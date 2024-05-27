package com.example.semestralka_vamz.push

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.semestralka_vamz.R

@Composable
fun HornyHrudnikScreen(navController: NavController) {

    val image1 = R.drawable.house // Identifikátor obrázka
    val image2 = R.drawable.cvik // Identifikátor obrázka
    Surface(
        color = Color(0xFF000015),
        modifier = Modifier.fillMaxSize()
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxSize().padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            item {
                Image(
                    painter = painterResource(id = image1),
                    contentDescription = null, // Umiestnenie obrázka
                    modifier = Modifier
                        .fillMaxWidth() // Nastaviť obrázok na celú dostupnú šírku
                        //.padding(10.dp)
                        .height(160.dp)

                )
                Text(
                    text = "Šikmý bench press",
                    fontWeight = FontWeight.Bold,
                    fontSize = 25.sp
                )
            }
            item {
                Image(
                    painter = painterResource(id = image1),
                    contentDescription = null, // Umiestnenie obrázka
                    modifier = Modifier
                        .fillMaxWidth() // Nastaviť obrázok na celú dostupnú šírku
                        //.padding(10.dp)
                        .height(160.dp)

                )
                Text(
                    text = "Tlak na šikmej lavičke s činkami",
                    fontWeight = FontWeight.Bold,
                    fontSize = 25.sp
                )
            }
            item {
                // Dolná lišta s tlačidlami
                BottomAppBar(
                    modifier = Modifier.height(65.dp)
                ) {
                    Row(
                        horizontalArrangement = Arrangement.SpaceEvenly, // Rozmiestnenie tlačidiel
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(10.dp)
                    ) {

                        Image(
                            painter = painterResource(id = image1),
                            contentDescription = null,
                            modifier = Modifier
                                .size(50.dp) // Veľkosť obrazka
                                .clickable { navController.navigate("CvicenieScreen") } // Navigácia na HomeScreen pri kliknutí

                        )

                        Image(
                            painter = painterResource(id = image2),
                            contentDescription = null,
                            modifier = Modifier
                                .size(50.dp) // Veľkosť obrazka
                                .clickable { navController.navigate("HomeScreen") } // Navigácia na HomeScreen pri kliknutí

                        )
                    }
                }
            }
        }
    }
}

