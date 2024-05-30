package com.example.semestralka_vamz.zaklad

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.compose.ui.text.style.TextAlign

data class Exercise(
    val name: String,
    val imageResId: Int,
    val route: String
)



@Composable
fun ExerciseScreen(navController: NavController, title: String, exercises: List<Exercise>) {
    Surface(
        color = Color(0xFF000017),
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                items(exercises) { exercise ->
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Image(
                            painter = painterResource(id = exercise.imageResId),
                            contentDescription = null,
                            modifier = Modifier
                                .width(180.dp)
                                .height(180.dp)
                        )
                        Spacer(modifier = Modifier.height(5.dp))
                        Button(
                            onClick = { navController.navigate(exercise.route) },
                            modifier = Modifier
                                .width(250.dp)
                                .height(60.dp)
                        ) {
                            Text(
                                text = exercise.name,
                                fontWeight = FontWeight.Bold,
                                fontSize = 22.sp,
                                textAlign = TextAlign.Center,
                                modifier = Modifier.fillMaxWidth()
                            )
                        }
                    }
                }
            }
            Spacer(modifier = Modifier.height(8.dp))
            SpodnaLista(navController = navController)
        }
    }
}

data class Cvik(
    val nazov: String,
    val imageResId: Int,
    val popis: String,
    val isExpanded: MutableState<Boolean> = mutableStateOf(false)
)
data class Cviky(
    val nazov: String,
    val imageResId1: Int,
    val popis1: String,
    val imageResId2: Int,
    val popis2: String,
    val isExpanded: MutableState<Boolean> = mutableStateOf(false)
)