package com.example.semestralka_vamz.pull

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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.semestralka_vamz.R

@Composable
fun PullScreen(navController: NavController) {
    val image1 = R.drawable.pull
    val image4 = R.drawable.house // Identifikátor obrázka
    val image5 = R.drawable.cvik // Identifikátor obrázka
    Surface(
        color = Color(0xFF000015), // Tmavomodré pozadie
        modifier = Modifier.fillMaxSize()
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            item {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp)
                ) {
                    Image(
                        painter = painterResource(id = image1),
                        contentDescription = null,
                        modifier = Modifier
                            .width(150.dp)
                            .height(150.dp)
                    )
                    Spacer(modifier = Modifier.width(16.dp))
                    Button(
                        onClick = { navController.navigate("ChrbatScreen") },
                        modifier = Modifier
                            .weight(1f)
                            .height(60.dp)
                    ) {
                        Text(
                            text = "Komplexný cvik na chrbát",
                            fontWeight = FontWeight.Bold,
                            fontSize = 18.sp
                        )
                    }
                }
            }
            item {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp)
                ) {
                    Image(
                        painter = painterResource(id = image1),
                        contentDescription = null,
                        modifier = Modifier
                            .width(150.dp)
                            .height(150.dp)
                    )
                    Spacer(modifier = Modifier.width(16.dp))
                    Button(
                        onClick = { navController.navigate("MedziLopatkovaCastScreen") },
                        modifier = Modifier
                            .weight(1f)
                            .height(60.dp)
                    ) {
                        Text(
                            text = "Medzi lopatková časť",
                            fontWeight = FontWeight.Bold,
                            fontSize = 18.sp,
                            textAlign = TextAlign.Center,
                        )
                    }
                }
            }
            item {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp)
                ) {
                    Image(
                        painter = painterResource(id = image1),
                        contentDescription = null,
                        modifier = Modifier
                            .width(150.dp)
                            .height(150.dp)
                    )
                    Spacer(modifier = Modifier.width(16.dp))
                    Button(
                        onClick = { navController.navigate("HornyChrbatScreen") },
                        modifier = Modifier
                            .weight(1f)
                            .height(50.dp)
                    ) {
                        Text(
                            text = "Horný chrbát",
                            fontWeight = FontWeight.Bold,
                            fontSize = 18.sp
                        )
                    }
                }
            }
            item {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp)
                ) {
                    Image(
                        painter = painterResource(id = image1),
                        contentDescription = null,
                        modifier = Modifier
                            .width(150.dp)
                            .height(150.dp)
                    )
                    Spacer(modifier = Modifier.width(16.dp))
                    Button(
                        onClick = { navController.navigate("KridlaScreen") },
                        modifier = Modifier
                            .weight(1f)
                            .height(50.dp)
                    ) {
                        Text(
                            text = "Krídla",
                            fontWeight = FontWeight.Bold,
                            fontSize = 18.sp
                        )
                    }
                }
            }
            item {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp)
                ) {
                    Image(
                        painter = painterResource(id = image1),
                        contentDescription = null,
                        modifier = Modifier
                            .width(150.dp)
                            .height(150.dp)
                    )
                    Spacer(modifier = Modifier.width(16.dp))
                    Button(
                        onClick = { navController.navigate("BicepsScreen") },
                        modifier = Modifier
                            .weight(1f)
                            .height(50.dp)
                    ) {
                        Text(
                            text = "Biceps",
                            fontWeight = FontWeight.Bold,
                            fontSize = 18.sp
                        )
                    }
                }
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
                            painter = painterResource(id = image5),
                            contentDescription = null,
                            modifier = Modifier
                                .size(50.dp) // Veľkosť obrazka
                                .clickable { navController.navigate("CvicenieScreen") } // Navigácia na HomeScreen pri kliknutí

                        )

                        Image(
                            painter = painterResource(id = image4),
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