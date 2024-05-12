package com.example.semestralka_vamz

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.semestralka_vamz.ui.theme.Semestralka_VamzTheme

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
                        composable("PushScreen") {PushScreen(navController) }
                        composable("PullScreen") {PullScreen(navController) }
                        composable("Legs_Abs_Screen") {Legs_Abs_Screen(navController) }
                    }
                }
            }
        }
    }
}

@Composable
fun WelcomeScreen(navController: NavController) {
    val customColor = Color(0xFF000015) //Vlastná farba
    val image = R.drawable.uvodna // Identifikátor obrázka

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = customColor, // Tmavomodré pozadie
    ) {
        Column(
            modifier = Modifier.fillMaxSize().padding(30.dp), // Odsadenie od kraja 30
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = image),
                contentDescription = null, // Umiestnenie obrázka
                modifier = Modifier
                    .fillMaxWidth() // Nastaviť obrázok na celú dostupnú šírku
                    .padding(10.dp)
                    .height(600.dp)

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


@Preview(showBackground = true)
@Composable
fun WelcomeScreenPreview() {
    Semestralka_VamzTheme {
        val navController = rememberNavController()
        WelcomeScreen(navController)
    }
}