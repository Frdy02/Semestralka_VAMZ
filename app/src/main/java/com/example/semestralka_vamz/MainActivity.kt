package com.example.semestralka_vamz

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.semestralka_vamz.legs_abs.BruchoScreen
import com.example.semestralka_vamz.legs_abs.Legs_Abs_Screen
import com.example.semestralka_vamz.legs_abs.NohyScreen
import com.example.semestralka_vamz.pull.BicepsScreen
import com.example.semestralka_vamz.pull.ChrbatScreen
import com.example.semestralka_vamz.pull.PredlaktieScreen
import com.example.semestralka_vamz.pull.PullScreen
import com.example.semestralka_vamz.push.HrudnikScreen
import com.example.semestralka_vamz.push.PushScreen
import com.example.semestralka_vamz.push.RamenaScreen
import com.example.semestralka_vamz.push.TricepsScreen
import com.example.semestralka_vamz.ui.theme.Semestralka_VamzTheme
import com.example.semestralka_vamz.zaklad.CvicenieScreen
import com.example.semestralka_vamz.zaklad.HomeScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Semestralka_VamzTheme {
                val navController = rememberNavController()
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    NavHost(navController, startDestination = "WelcomeScreen") {
                        composable("WelcomeScreen") { WelcomeScreen(navController) }
                        composable("HomeScreen") { HomeScreen(navController) }
                        composable("PushScreen") { PushScreen(navController) }
                        composable("PullScreen") { PullScreen(navController) }
                        composable("Legs_Abs_Screen") { Legs_Abs_Screen(navController) }

                        composable("CvicenieScreen") { CvicenieScreen(navController) }

                        composable("HrudnikScreen") { HrudnikScreen(navController) }
                        composable("RamenaScreen") { RamenaScreen(navController) }
                        composable("TricepsScreen") { TricepsScreen(navController) }

                        composable("ChrbatScreen") { ChrbatScreen(navController) }
                        composable("PredlaktieScreen") { PredlaktieScreen(navController) }
                        composable("BicepsScreen") { BicepsScreen(navController) }

                        composable("NohyScreen") { NohyScreen(navController) }
                        composable("BruchoScreen") { BruchoScreen(navController) }
                    }
                }
            }
        }
    }
}

@Composable
fun WelcomeScreen(navController: NavController) {
    val customColor = Color(0xFF000017)
    val image = R.drawable.uvodna

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = customColor
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxSize().padding(10.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            item {
                Image(
                    painter = painterResource(id = image),
                    contentDescription = null, // Umiestnenie obrázka
                    modifier = Modifier
                        .fillMaxWidth() // Nastaviť obrázok na celú dostupnú šírku
                        .padding(10.dp)
                        .height(550.dp)
                )

                Text(
                    text = "Treningový plán",
                    color = Color.White,
                    fontSize = 40.sp, // Veľkosť
                    fontWeight = FontWeight.Bold // Tučné
                )
                Spacer(modifier = Modifier.height(30.dp))
                Button(
                    onClick = { navController.navigate("HomeScreen") },
                    modifier = Modifier
                        .width(200.dp) // Nastaví šírku tlačidla na 200px
                        .height(60.dp) // Nastaví výšku tlačidla na 60px
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
