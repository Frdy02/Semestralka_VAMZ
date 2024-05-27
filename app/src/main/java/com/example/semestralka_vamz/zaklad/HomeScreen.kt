package com.example.semestralka_vamz.zaklad


import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.material3.Button
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.semestralka_vamz.R

@Composable
fun HomeScreen(navController: NavHostController) {
    val customColor = Color(0xFF000015)
    val image1 = R.drawable.push // Identifikátor obrázka
    val image2 = R.drawable.pull // Identifikátor obrázka
    val image3 = R.drawable.legs // Identifikátor obrázka
    val image4 = R.drawable.house // Identifikátor obrázka
    val image5 = R.drawable.cvik // Identifikátor obrázka

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = customColor, // Tmavomodré pozadie
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxSize().padding(10.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        )
        {
            item {
                Image(
                    painter = painterResource(id = image1),
                    contentDescription = null, // Umiestnenie obrázka
                    modifier = Modifier
                        .fillMaxWidth() // Nastaviť obrázok na celú dostupnú šírku
                        //.padding(10.dp)
                        .height(160.dp)

                )
                Button(
                    onClick = { navController.navigate("PushScreen") },
                    modifier = Modifier
                        .padding(10.dp)
                        .width(150.dp)
                        .height(50.dp)
                ) {
                    Text(
                        text = "Push",
                        fontWeight = FontWeight.Bold,
                        fontSize = 25.sp
                    )
                }
            }
            item {
                Image(
                    painter = painterResource(id = image2),
                    contentDescription = null, // Umiestnenie obrázka
                    modifier = Modifier
                        .fillMaxWidth() // Nastaviť obrázok na celú dostupnú šírku
                        //.padding(10.dp)
                        .height(160.dp)

                )
                Button(
                    onClick = { navController.navigate("PullScreen") },
                    modifier = Modifier
                        .padding(10.dp)
                        .width(150.dp)
                        .height(50.dp)
                ) {
                    Text(
                        text = "Pull",
                        fontWeight = FontWeight.Bold,
                        fontSize = 25.sp
                    )
                }
            }
            item {
                Image(
                    painter = painterResource(id = image3),
                    contentDescription = null, // Umiestnenie obrázka
                    modifier = Modifier
                        .fillMaxWidth() // Nastaviť obrázok na celú dostupnú šírku
                        .padding(10.dp)
                        .height(160.dp)

                )
                Button(
                    onClick = { navController.navigate("Legs_Abs_Screen") },
                    modifier = Modifier
                        .padding(10.dp)
                        .width(180.dp)
                        .height(50.dp)

                ) {
                    Text(
                        text = "Legs + Abs",
                        fontWeight = FontWeight.Bold,
                        fontSize = 25.sp
                    )
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
