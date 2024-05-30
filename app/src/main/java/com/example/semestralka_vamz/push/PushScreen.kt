package com.example.semestralka_vamz.push

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.semestralka_vamz.zaklad.Exercise
import com.example.semestralka_vamz.zaklad.ExerciseScreen
import com.example.semestralka_vamz.R

@Composable
fun PushScreen(navController: NavController) {
    val exercises = listOf(
        Exercise("Cviky na hrudník", R.drawable.hrudnik, "HrudnikScreen"),
        Exercise("Cviky na ramená", R.drawable.ramena, "RamenaScreen"),
        Exercise("Cviky na triceps", R.drawable.triceps, "TricepsScreen")
    )

    ExerciseScreen(navController = navController, title = "Push", exercises = exercises)
}