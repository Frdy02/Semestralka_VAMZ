package com.example.semestralka_vamz.registracia

import android.content.SharedPreferences
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.navigation.NavController
import com.example.semestralka_vamz.MainActivity
import com.example.semestralka_vamz.R


/**
 * RegistraciaScreen riadi celý proces registrácie, ktorý pozostáva zo štyroch krokov:
 * osobné údaje, cieľe, kondičná úroveň a úvodné testy.
 * Tato obrazovka spolu s danými krokmi sa zobrazi iba raz a to pri prvom spusteni aplikacie.
 * Údaje zapisane v provtných testov, si može pootm použivateľ pozrieť v pokrokoch
 *
 * @param navController NavController použitý na navigáciu medzi obrazovkami.
 * @param sharedPreferences Zdieľané preferencie na uloženie údajov.
 * @param viewModel ViewModel, ktorý udržiava stav registrácie.
 */
@Composable
fun RegistraciaScreen(navController: NavController, sharedPreferences: SharedPreferences, viewModel: RegistraciaViewModel) {
    var currentStep by rememberSaveable { mutableIntStateOf(0) }

    val steps = listOf<@Composable () -> Unit>(
        { OsobneUdajeScreen(onNext = { currentStep++ }, sharedPreferences = sharedPreferences, viewModel = viewModel) },
        { FitnessScreen(onNext = { currentStep++ }) },
        { CieleScreen(onNext = { currentStep++ }) },
        {
            TestScreen(onNext = {
                sharedPreferences.edit().putBoolean("isFirstRun", false).apply()
                navController.navigate("HomeScreen")
                (navController.context as? MainActivity)?.ziadajPovolenieNaNotifikacie()
            }, sharedPreferences = sharedPreferences, viewModel = viewModel)
        }
    )

    Surface(
        color = colorResource(id = R.color.background_color),
        modifier = Modifier.fillMaxSize()
    ) {
        steps[currentStep]()
    }
}