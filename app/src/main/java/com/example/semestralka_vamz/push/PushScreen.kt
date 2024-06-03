package com.example.semestralka_vamz.push

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.semestralka_vamz.zaklad.CastiTela
import com.example.semestralka_vamz.zaklad.ExerciseScreen
import com.example.semestralka_vamz.R

/**
 * PushScreen je obrazovka, ktorá zobrazuje buttony, pomcou ktorých sa použivateľ ndostane na cviky hrudníka, ramien a tricepsov.
 *
 * @param navController NavController použitý na navigáciu medzi obrazovkami.
 */
@Composable
fun PushScreen(navController: NavController) {
    val exercises = listOf(
        CastiTela("Cviky na hrudník", R.drawable.hrudnik, "HrudnikScreen"),
        CastiTela("Cviky na ramená", R.drawable.ramena, "RamenaScreen"),
        CastiTela("Cviky na triceps", R.drawable.triceps, "TricepsScreen")
    )

    ExerciseScreen(navController = navController, exercises = exercises)
}