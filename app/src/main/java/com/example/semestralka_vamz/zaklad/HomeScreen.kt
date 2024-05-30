package com.example.semestralka_vamz.zaklad

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.semestralka_vamz.R

@Composable
fun HomeScreen(navController: NavHostController) {
    val customColor = Color(0xFF000017)
    val image1 = R.drawable.push
    val image2 = R.drawable.pull
    val image3 = R.drawable.legs

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = customColor,
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxSize().padding(10.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            item { ExerciseButton(navController, "PushScreen", image1, "Push") }
            item { ExerciseButton(navController, "PullScreen", image2, "Pull") }
            item { ExerciseButton(navController, "Legs_Abs_Screen", image3, "Legs + Abs") }

            item {
                Spacer(modifier = Modifier.height(8.dp))
                SpodnaLista(navController = navController)
            }
        }
    }
}

@Composable
fun ExerciseButton(navController: NavHostController, route: String, imageRes: Int, text: String) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(15.dp)
    ) {
        Image(
            painter = painterResource(id = imageRes),
            contentDescription = text,
            modifier = Modifier
                .fillMaxWidth()
                .height(160.dp)
        )
        Button(
            onClick = { navController.navigate(route) },
            modifier = Modifier
                .width(180.dp)
                .height(50.dp)
        ) {
            Text(
                text = text,
                fontWeight = FontWeight.Bold,
                fontSize = 25.sp
            )
        }
    }
}


