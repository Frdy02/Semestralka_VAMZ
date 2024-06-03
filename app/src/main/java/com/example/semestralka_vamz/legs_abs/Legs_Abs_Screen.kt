package com.example.semestralka_vamz.legs_abs

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.semestralka_vamz.R
import com.example.semestralka_vamz.zaklad.CastiTela
import com.example.semestralka_vamz.zaklad.ExerciseScreen

/**
 * Legs_Abs_Screen je obrazovka, ktorá zobrazuje buttony, pomcou ktorých sa použivateľ ndostane na cviky brucha, nôh.
 *
 * @param navController NavController použitý na navigáciu medzi obrazovkami.
 */
@Composable
fun Legs_Abs_Screen(navController: NavController) {
    val exercises = listOf(
        CastiTela("Cviky na nohy", R.drawable.nohy, "NohyScreen"),
        CastiTela("Cviky na brucho", R.drawable.brucho, "BruchoScreen"),
    )

    ExerciseScreen(navController = navController, exercises = exercises)
}