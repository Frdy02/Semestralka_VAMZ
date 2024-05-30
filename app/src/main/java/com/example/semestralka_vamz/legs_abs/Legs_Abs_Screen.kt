package com.example.semestralka_vamz.legs_abs

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.semestralka_vamz.R
import com.example.semestralka_vamz.zaklad.Exercise
import com.example.semestralka_vamz.zaklad.ExerciseScreen

@Composable
fun Legs_Abs_Screen(navController: NavController) {
    val exercises = listOf(
        Exercise("Cviky na nohy", R.drawable.hrudnik, "NohyScreen"),
        Exercise("Cviky na brucho", R.drawable.ramena, "BruchoScreen"),
    )

    ExerciseScreen(navController = navController, title = "Push", exercises = exercises)
}