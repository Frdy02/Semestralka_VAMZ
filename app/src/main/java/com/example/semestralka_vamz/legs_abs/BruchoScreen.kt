package com.example.semestralka_vamz.legs_abs

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
fun BruchoScreen(navController: NavController) {
    val cviky = remember {
        listOf(
            Cviky(
                "Horná časť",
                R.drawable.horna1,
                createAnnotatedString(
                    "Skracovačky na stroji: \n",
                    "1.Sadnite si na sedadlo, uchopte držadlá a dajte chodidlá pod valčeky stroja\n" +
                            "2.Stiahnite brušné svaly a pritiahnite trup ku kolenám\n" +
                            "3.Vracajte sa do východiskovej polohy"
                ),
                R.drawable.horna2,
                createAnnotatedString(
                    "Sed ľah na šikmej lavičke: \n",
                    "1. Ľahnite si hlavou smerom dole na šikmú lavičku a chodidlá zaháknite\n" +
                            "2. Ruky dajte k stehnám, bokom, hrudníku či za hlavu (čím vyššie od stehien tým viac zaťažíte brušné svaly).\n" +
                            "3. Dvíhajte sa, hrudník priblížený k panve, aby nezaberal chrbát a snažte sa dostať bradou ku kolenám\n" +
                            "4. Potom sa vracajte rovnakým oblúkom do začínajúcej pozície, ale nedotýkajte sa chrbtom lavičky.\n" +
                            "5. Pri vyčerpaní si v ďalších sériách môžete pomôcť klamaním, pri zdvíhaní sa z dolnej pozície dávajte ruky trochu dopredu."
                )
            ),
            Cviky(
                "Bočná časť",
                R.drawable.bocne1,
                createAnnotatedString(
                    "Úklon s jednoručkou: \n",
                    "1. Stojte vzpriamene a uchopte jednoručku do ľavej ruky, pravú ruku majte za hlavou\n" +
                            "2. Trup ohnite doľava a spustite jednoručku ku kolenu\n" +
                            "3. Narovnaním trupu sa sťahujú pravé šikmé brušné svaly"
                ),
                R.drawable.bocne2,
                createAnnotatedString(
                    "Bočné striedavé sed ľahy: \n",
                    "1. Ľahnite si hlavou smerom dole na šikmú lavičku a chodidlá zaháknite, ruky dajte za hlavu\n" +
                            "2. Dvíhajte sa a buďte pritom “zrolovaný do kĺbka” (hrudník priblížený k panve) aby nezaberal chrbát\n" +
                            "3. Natáčajte trup aby ste sa dotkli pravým lakťom ľavého kolena a pri ďalšom opakovaní naopak\n" +
                            "4. Pri vyčerpaní si v ďalších sériách môžete pomôcť klamaním, pri zdvíhaní sa zo zeme dávajte ruky trochu dopredu."
                )
            ),
            Cviky(
                "Dolná časť",
                R.drawable.dolne1,
                createAnnotatedString(
                    "Dvíhanie nôh na šikmej lavičke: \n",
                    "1. Ľahnite si na šikmú lavičku s nohami hore\n" +
                            "2. Zdvíhajte nohy v bedrách a priťahujte stehná k hrudi, kolená majte mierne pokrčené\n" +
                            "3. Pomaly spúštajte nohy do východiskovej polohy"
                ),
                R.drawable.dolne2,
                createAnnotatedString(
                    "Dvíhanie nôh vo vise: \n",
                    "1. Rukami sa zaveste na hrazdu alebo iné bradlá. Nohy vo východzej pozícii sú spustené dole (nie úplne kolmo, ale snažíme sa ich mať len mierne prednožené pred telom)\n" +
                            "2. Následne môžeme priťahovať nohy k telu, pričom nohy ohýname v kolenách a bedrách a dvíhame ich tak vysoko, až sa nám takmer dotknú brucha.\n" +
                            "3. Následne nohy spúšťame naspäť do východzej pozície.\n" +
                            "4. Pre sťaženie môžeme toto robiť s vystretými nohami."
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
