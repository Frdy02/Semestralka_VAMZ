package com.example.semestralka_vamz.pull

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.semestralka_vamz.R
import com.example.semestralka_vamz.zaklad.Exercise
import com.example.semestralka_vamz.zaklad.ExerciseScreen

@Composable
fun PullScreen(navController: NavController) {
    val exercises = listOf(
        Exercise("Cviky na chrbát", R.drawable.hrudnik, "ChrbatScreen"),
        Exercise("Cviky na biceps", R.drawable.ramena, "BicepsScreen"),
        Exercise("Cviky na predlaktie", R.drawable.predlaktie, "PredlaktieScreen")
    )

    ExerciseScreen(navController = navController, title = "Push", exercises = exercises)
}
