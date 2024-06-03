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
import com.example.semestralka_vamz.zaklad.Cviky
import com.example.semestralka_vamz.zaklad.SpodnaLista
import com.example.semestralka_vamz.zaklad.upravaTextu

/**
 * ChrbatScreen je obrazovka, ktorá zobrazuje cvičenia na posilnenie chrbta.
 *
 * @param navController NavController použitý na navigáciu medzi obrazovkami.
 */
@Composable
fun ChrbatScreen(navController: NavController) {
    val cviky = remember {
        listOf(
            Cviky(
                "Horná časť chrbta",
                R.drawable.vrch1,
                upravaTextu(
                    "Veslovanie s kladkou v sede: \n",
                    "1. Uchopte držadlá kladky rukami natiahnutými dopredu\n" +
                            "2. Držadlá priťahujte smerom k hrudníku, chrbát majte počas celého cvičenia rovný\n" +
                            "3. Vráťte držadlá späť do východiskovej polohy"
                ),
                R.drawable.vrch2,
                upravaTextu(
                    "Krčenie ramien s jednoručkami: \n",
                    "1. Postavte sa rovno a uchopte jednoručky nadhmatom, ruky majte spustené po stranách tak, že dlane smerujú do tela\n" +
                            "2. Ramená zdvíhajte čo najvyššie, ruky zostávajú natiahnuté\n" +
                            "3. Jednoručky spúšťajte späť do východiskovej polohy"
                )
            ),
            Cviky(
                "Stredná časť chrbta",
                R.drawable.stred_c1,
                upravaTextu(
                    "Sťahovanie hornej kladky, širokým úchopom: \n",
                    "1. Uchopte tyč nadhmatom s rukami o 15 cm vzdialených od seba než je šírka ramien\n" +
                            "2. Tyč sťahujte dole k hornej časti hrudi a stláčajte široký chrbtový sval\n" +
                            "3. Vráťte tyč späť do východzej polohy nad hlavou"
                ),
                R.drawable.stred_c2,
                upravaTextu(
                    "Príťahy v predklone s jednoručkou: \n",
                    "1. Jednoručku priťahujte dlaňou smerom k sebe. Druhú ruku a koleno položte na lavicu tak, aby chrbtica bola rovná a paralelne s podlahou\n" +
                            "2. Jednoručku priťahujte vertikálne hore pozdĺž trupu, zdvíhajte pritom lakeť čo najvyššie\n" +
                            "3. Spustite jednoručku späť do východiskovej polohy"
                )
            ),
            Cviky(
                "Dolná časť chrbta",
                R.drawable.dolny1,
                upravaTextu(
                    "Hyperextenzia: \n",
                    "1. Držadlá stroja uchopte natiahnutím rúk a trup oprite o hrudnú opierku\n" +
                            "2. Držadlá priťahujte k hornej časti brucha, chrbtica nech je rovná\n" +
                            "3. Závažie vráťte späť do východiskovej polohy"
                ),
                R.drawable.dolny2,
                upravaTextu(
                    "Mŕtvy ťah: \n",
                    "1. Činku uchopte nadhmatom v šírke ramien s natiahnutými rukami a dajte sa do mierneho predklonu\n" +
                            "2. Narovnaním tela zdvíhajte činku na úroveň bokov, chrbticu majte rovno a lakte napnuté\n" +
                            "3. Pomaly spúšťajte činku späť na podlahu"
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
