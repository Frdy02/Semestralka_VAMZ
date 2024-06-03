package com.example.semestralka_vamz

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.semestralka_vamz.legs_abs.BruchoScreen
import com.example.semestralka_vamz.legs_abs.Legs_Abs_Screen
import com.example.semestralka_vamz.legs_abs.NohyScreen
import com.example.semestralka_vamz.notifikacia.NotifikacnyPomocnik
import com.example.semestralka_vamz.pull.BicepsScreen
import com.example.semestralka_vamz.pull.ChrbatScreen
import com.example.semestralka_vamz.pull.PredlaktieScreen
import com.example.semestralka_vamz.pull.PullScreen
import com.example.semestralka_vamz.push.HrudnikScreen
import com.example.semestralka_vamz.push.PushScreen
import com.example.semestralka_vamz.push.RamenaScreen
import com.example.semestralka_vamz.push.TricepsScreen
import com.example.semestralka_vamz.ui.theme.Semestralka_VamzTheme
import com.example.semestralka_vamz.zaklad.HomeScreen
import com.example.semestralka_vamz.pokrok.PokrokScreen
import com.example.semestralka_vamz.pokrok.PokrokViewModel
import com.example.semestralka_vamz.registracia.RegistraciaScreen
import com.example.semestralka_vamz.registracia.RegistraciaViewModel

/**
 * MainActivity je hlavný vstupný bod aplikácie.
 * Nastavuje navigáciu a inicializuje zdieľané preferencie.
 * Taktiež pýta od zakaznikov ak to nemaju povolené prístup k notifikáciam
 */
class MainActivity : ComponentActivity() {

    private val requestPermissionLauncher = registerForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) { isGranted: Boolean ->
        if (isGranted) {
            // Povolenie bolo udelené, poslať notifikáciu
            NotifikacnyPomocnik.posliNotifikaciu(
                this,
                "Registrácia dokončená",
                "Vaša registrácia bola úspešne dokončená."
            )
        } else {
            // Povolenie nebolo udelené
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Vytvorenie notifikačného kanála
        NotifikacnyPomocnik.vytvorNotifikacnyKanal(this)

        setContent {
            Semestralka_VamzTheme {
                val navController = rememberNavController()
                val sharedPreferences = getSharedPreferences("app_preferences", Context.MODE_PRIVATE)
                val isFirstRun = sharedPreferences.getBoolean("isFirstRun", true)

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    NavHost(navController, startDestination = if (isFirstRun) "RegistraciaScreen" else "WelcomeScreen") {
                        composable("WelcomeScreen") { WelcomeScreen(navController) }
                        composable("HomeScreen") { HomeScreen(navController) }
                        composable("PushScreen") { PushScreen(navController) }
                        composable("PullScreen") { PullScreen(navController) }
                        composable("Legs_Abs_Screen") { Legs_Abs_Screen(navController) }
                        composable("HrudnikScreen") { HrudnikScreen(navController) }
                        composable("RamenaScreen") { RamenaScreen(navController) }
                        composable("TricepsScreen") { TricepsScreen(navController) }
                        composable("ChrbatScreen") { ChrbatScreen(navController) }
                        composable("PredlaktieScreen") { PredlaktieScreen(navController) }
                        composable("BicepsScreen") { BicepsScreen(navController) }
                        composable("NohyScreen") { NohyScreen(navController) }
                        composable("BruchoScreen") { BruchoScreen(navController) }
                        composable("PokrokScreen") {
                            val pokrokViewModel: PokrokViewModel = viewModel()
                            PokrokScreen(navController, sharedPreferences, pokrokViewModel)
                        }
                        composable("RegistraciaScreen") {
                            val registraciaViewModel: RegistraciaViewModel = viewModel()
                            RegistraciaScreen(navController, sharedPreferences, registraciaViewModel)
                        }
                    }
                }
            }
        }
    }

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    fun ziadajPovolenieNaNotifikacie() {
        when {
            ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.POST_NOTIFICATIONS
            ) == PackageManager.PERMISSION_GRANTED -> {
                // Povolenie je už udelené, poslať notifikáciu
                NotifikacnyPomocnik.posliNotifikaciu(
                    this,
                    "Registrácia dokončená",
                    "Vaša registrácia bola úspešne dokončená."
                )
            }
            else -> {
                // Priamo požiadame o povolenie
                requestPermissionLauncher.launch(Manifest.permission.POST_NOTIFICATIONS)
            }
        }
    }
}

/**
 * WelcomeScreen je prvá obrazovka, ktorú užívateľ vidí ked druhy krát otvorí aplikaciu. Prvý krat vidí RegistraciaScreen.
 * Zobrazuje uvítací obrázok a tlačidlo na spustenie aplikácie.
 *
 * @param navController NavController použitý na navigáciu medzi obrazovkami.
 */
@Composable
fun WelcomeScreen(navController: NavController) {
    Surface(
        color = colorResource(id = R.color.background_color),
    ){
        LazyColumn(
            modifier = Modifier.fillMaxSize().padding(10.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            item {
                Image(
                    painter = painterResource(id = R.drawable.uvodna),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp)
                        .height(550.dp)
                )

                Text(
                    text = "Treningový plán",
                    color = Color.White,
                    fontSize = 40.sp,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(30.dp))

                Button(
                    onClick = { navController.navigate("HomeScreen") },
                    modifier = Modifier
                        .width(200.dp)
                        .height(60.dp)
                ) {
                    Text(
                        text = "Štart",
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
    }
}

