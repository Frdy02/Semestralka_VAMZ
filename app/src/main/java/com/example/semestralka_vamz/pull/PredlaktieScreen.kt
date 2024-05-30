package com.example.semestralka_vamz.pull

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.semestralka_vamz.R
import com.example.semestralka_vamz.zaklad.Cvik
import com.example.semestralka_vamz.zaklad.SpodnaLista

@Composable
fun PredlaktieScreen(navController: NavController) {
    val cviky = remember {
        listOf(
            Cvik("Klopenie zápästia\ns veľkou činkou", R.drawable.predlaktie1, "Popis cviku "),
            Cvik("Zdvih s veľkou\n činkou nadhmatom", R.drawable.predlaktie2, "Popis cviku "),
        )
    }

    Surface(
        color = Color(0xFF000015),
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
                    .padding(25.dp),
                verticalArrangement = Arrangement.spacedBy(50.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                items(cviky) { cvik ->
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable { cvik.isExpanded.value = !cvik.isExpanded.value },
                    ) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier
                                .fillMaxWidth()
                                .clickable { cvik.isExpanded.value = !cvik.isExpanded.value }
                        ) {
                            Text(
                                text = cvik.nazov,
                                fontWeight = FontWeight.Bold,
                                fontSize = 25.sp,
                                textAlign = TextAlign.Center,
                            )
                            if (cvik.isExpanded.value) {
                                Image(
                                    painter = painterResource(id = cvik.imageResId),
                                    contentDescription = null,
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(10.dp)
                                        .height(160.dp)
                                )
                                Text(
                                    text = cvik.popis,
                                    fontWeight = FontWeight.Normal,
                                    fontSize = 18.sp,
                                    color = Color.White,
                                    modifier = Modifier.padding(10.dp)
                                )
                            }
                        }
                    }
                }
            }
            SpodnaLista(navController = navController)
        }
    }
}


