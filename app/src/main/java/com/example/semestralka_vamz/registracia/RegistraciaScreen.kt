package com.example.semestralka_vamz.registracia

import android.content.SharedPreferences
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController

@Composable
fun RegistraciaScreen(navController: NavController, sharedPreferences: SharedPreferences) {
    var currentStep by remember { mutableStateOf(0) }
    val steps = listOf<@Composable () -> Unit>(
        { OsobneUdajeScreen(onNext = { currentStep++ }, sharedPreferences = sharedPreferences) },
        { FitnessScreen(onNext = { currentStep++ }) },
        { CieleScreen(onNext = { currentStep++ }) },
        {
            TestScreen(onNext = {
                sharedPreferences.edit().putBoolean("isFirstRun", false).apply()
                navController.navigate("HomeScreen")
            }, sharedPreferences = sharedPreferences )
        }
    )

    Surface(
        color = Color(0xFF000015),
        modifier = Modifier.fillMaxSize()
    ) {
        steps[currentStep]()
    }
}