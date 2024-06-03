package com.example.semestralka_vamz.zaklad

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.semestralka_vamz.R

/**
 * HomeScreen zobrazuje hlavné menu aplikácie, umožňujúce užívateľovi navigovať
 * do rôznych kategórií cvičení ako je push, pull a legs+abs, taktiež ma dole spodnu lištu.
 *
 * @param navController NavController použitý na navigáciu medzi obrazovkami.
 */
@Composable
fun HomeScreen(navController: NavHostController) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = colorResource(id = R.color.background_color),
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxSize().padding(10.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            item { SplitButton(navController, "PushScreen", R.drawable.push, "Push") }
            item { SplitButton(navController, "PullScreen", R.drawable.pull, "Pull") }
            item { SplitButton(navController, "Legs_Abs_Screen", R.drawable.legs, "Legs + Abs") }

            item {
                Spacer(modifier = Modifier.height(8.dp))
                SpodnaLista(navController = navController)
            }
        }
    }
}



