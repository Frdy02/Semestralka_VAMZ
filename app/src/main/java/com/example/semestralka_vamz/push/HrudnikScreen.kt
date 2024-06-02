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
fun HrudnikScreen(navController: NavController) {
    val cviky = remember {
        listOf(
            Cviky(
                "Horná časť hrudníku",
                R.drawable.horny1,
                createAnnotatedString(
                    "Šikmý bench press:\n",
                    "1. Na šikmej lavičke uchopte činku nadhmatom na šírku ramien.\n" +
                            "2. Spustite činku pomaly dole, až kým sa dotkne hrudi.\n" +
                            "3. Zdvihnite činku priamo až do napnutých lakťov."
                ),
                R.drawable.horny2,
                createAnnotatedString(
                    "Tlak s jednoručkami na šikmej lavičke:\n",
                    "1. V sede na šikmej lavičke uchopte jednoručky na úrovni hrudníku dlaňami k sebe\n" +
                            "2. Jednoručky tlačte hore až do napnutia lakťov\n" +
                            "3. Spustite jednoručky späť k hornej časti hrudníku"
                )
            ),
            Cviky(
                "Stredná časť hrudníku",
                R.drawable.stred1,
                createAnnotatedString(
                    "Bench press:\n",
                    "1. V ľahu na lavičke uchopte činku nadhmatom na šírku ramien\n" +
                            "2. Pomalým pohybom spúštajte činku dole, až kým sa jemne dotkne strednej časti hrudníka\n" +
                            "3. Tlačte činku priamo hore až do napnutia lakťov"
                ),
                R.drawable.stred2,
                createAnnotatedString(
                    "Rozpažovanie na stroji:\n",
                    "1. Uchopte vertikálne držadlá, lakte majte zľahka ohnuté\n" +
                            "2. Držadlá pritiahnite k sebe tak, aby sa stretli pred hrudníkom\n" +
                            "3. Vrátte ruky späť do východiskovej polohy, lakte pritom majte stále hore"
                )
            ),
            Cviky(
                "Dolná časť hrudníku",
                R.drawable.dole1,
                createAnnotatedString(
                    "Kliky na bradlách na hrudník:\n",
                    "1. Uchopte tyče, aby telo viselo dole a lakte boli napnuté\n" +
                            "2. Pomaly ohýbajte lakte a spúšťajte trup dole, pokiaľ nadlakte nie je paralelne s podlahou (trup majte stále rovno)\n" +
                            "3. Zdvihnite sa späť hore až do napnutia lakťov"
                ),
                R.drawable.dole2,
                createAnnotatedString(
                    "Prekríženie s kladkou:\n",
                    "1. Postavte sa rovno a uchopte držadlá hornej kladky\n" +
                            "2. Pritiahnite držadlá dole cez pás tak, aby sa ruky pred pásom dotýkali, lakte majte zľahka ohnuté\n" +
                            "3. Pomaly vracajte ruky späť do východiskovej polohy na úroveň ramien"
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
            horizontalAlignment = Alignment.CenterHorizontally,

        ) {
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp),
                verticalArrangement = Arrangement.spacedBy(50.dp),
                horizontalAlignment = Alignment.CenterHorizontally,

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
                                        .height(300.dp)
                                        .padding(8.dp)
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
                                        .height(300.dp)
                                        .padding(8.dp)
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

