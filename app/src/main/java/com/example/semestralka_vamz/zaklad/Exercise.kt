package com.example.semestralka_vamz.zaklad

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.navigation.NavHostController
import com.example.semestralka_vamz.R


/**
 * ExerciseScreen je obrazovka, kde sú zobrazené rôzne cviky na základe daného zoznamu cvikov.
 *
 * @param navController NavController použitý na navigáciu medzi obrazovkami.
 * @param exercises Zoznam cvikov, ktoré sa majú zobraziť.
 */
@Composable
fun ExerciseScreen(navController: NavController, exercises: List<CastiTela>) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = colorResource(id = R.color.background_color)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(15.dp),
                horizontalAlignment = Alignment.CenterHorizontally

            ) {
                items(exercises) { exercise ->
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Image(
                            painter = painterResource(id = exercise.imageResId),
                            contentDescription = null,
                            modifier = Modifier
                                .width(180.dp)
                                .height(180.dp)
                        )
                        Spacer(modifier = Modifier.height(5.dp))
                        Button(
                            onClick = { navController.navigate(exercise.route) },
                            modifier = Modifier
                                .width(250.dp)
                                .height(60.dp)
                        ) {
                            Text(
                                text = exercise.name,
                                fontWeight = FontWeight.Bold,
                                fontSize = 22.sp,
                                textAlign = TextAlign.Center,
                                modifier = Modifier.fillMaxWidth()
                            )
                        }
                    }
                }
            }
            Spacer(modifier = Modifier.height(8.dp))
            SpodnaLista(navController = navController)
        }
    }
}

/**
 * ExerciseButton je kompozitná funkcia, ktorá predstavuje tlačidlo s obrázkom a textom.
 * Po kliknutí naviguje na určenú trasu.
 * Slúži na to aby sa obišla duplikacia kodu
 *
 * @param navController NavController použitý na navigáciu medzi obrazovkami.
 * @param route Trasa, na ktorú sa má navigovať po kliknutí na tlačidlo.
 * @param imageRes ID zdroja obrázka, ktorý sa má zobraziť na tlačidle.
 * @param text Text, ktorý sa má zobraziť na tlačidle.
 */
@Composable
fun SplitButton(navController: NavHostController, route: String, imageRes: Int, text: String) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(15.dp)
    ) {
        Image(
            painter = painterResource(id = imageRes),
            contentDescription = text,
            modifier = Modifier
                .fillMaxWidth()
                .height(160.dp)
        )
        Button(
            onClick = { navController.navigate(route) },
            modifier = Modifier
                .width(180.dp)
                .height(50.dp)
        ) {
            Text(
                text = text,
                fontWeight = FontWeight.Bold,
                fontSize = 25.sp
            )
        }
    }
}

/**
 * Funkcia na vytvorenie AnnotatedString so zvýrazneným textom.
 *
 * @param boldText Text, ktorý má byť zvýraznený.
 * @param normalText Normálny text, ktorý nasleduje za zvýrazneným textom.
 * @return AnnotatedString s formátovaným textom.
 */
fun upravaTextu(boldText: String, normalText: String): AnnotatedString {
    return buildAnnotatedString {
        withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
            append(boldText)
        }
        withStyle(style = SpanStyle(fontWeight = FontWeight.Normal)) {
            append(normalText)
        }
    }
}