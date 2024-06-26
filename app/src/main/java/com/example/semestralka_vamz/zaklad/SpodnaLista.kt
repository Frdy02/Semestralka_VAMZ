package com.example.semestralka_vamz.zaklad

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.semestralka_vamz.R

/**
 * SpodnaLista predstavuje dolný navigačný panel v aplikácii.
 * Umožňuje navigáciu medzi domovskou obrazovkou a obrazovkou pokroku.
 *
 * @param navController NavController použitý na navigáciu medzi obrazovkami.
 * @param modifier Modifier použitý na úpravu alebo pridanie správania k SpodnaLista.
 */
@Composable
fun SpodnaLista(navController: NavController, modifier: Modifier = Modifier) {
    val backgroundColor = Color.DarkGray
    Surface(
        color = backgroundColor,
        modifier = modifier
            .fillMaxWidth()
            .height(60.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.fillMaxWidth().padding(4.dp)
        ) {
            Image(
                painter = painterResource(R.drawable.cvik),
                contentDescription = "CvicenieScreen",
                modifier = Modifier
                    .size(70.dp)
                    .clickable { navController.navigate("PokrokScreen") }
            )
            Image(
                painter = painterResource(R.drawable.house),
                contentDescription = "HomeScreen",
                modifier = Modifier
                    .size(70.dp)
                    .clickable { navController.navigate("HomeScreen") }
            )
        }
    }
}



