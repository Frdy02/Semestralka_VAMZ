package com.example.semestralka_vamz.pull

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.semestralka_vamz.R
import com.example.semestralka_vamz.zaklad.CastiTela
import com.example.semestralka_vamz.zaklad.ExerciseScreen

/**
 * PullScreen je obrazovka, ktorá zobrazuje buttony, pomcou ktorých sa použivateľ ndostane na cviky chrbta, bicepsov a predlaktia.
 *
 * @param navController NavController použitý na navigáciu medzi obrazovkami.
 */
@Composable
fun PullScreen(navController: NavController) {
    val exercises = listOf(
        CastiTela("Cviky na chrbát", R.drawable.chrbat, "ChrbatScreen"),
        CastiTela("Cviky na biceps", R.drawable.biceps, "BicepsScreen"),
        CastiTela("Cviky na predlaktie", R.drawable.predlaktie, "PredlaktieScreen")
    )

    ExerciseScreen(navController = navController, exercises = exercises)
}
