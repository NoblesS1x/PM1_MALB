package net.noble.notes_nav_test

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController


@Composable
fun PantallaTres(navController: NavHostController){
    Column (
        modifier= Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment =  Alignment.CenterHorizontally
    ){
        Text(text = "This is ThreeScreen")
        Button(onClick = { navController.navigate(Routes.PantallaUno.route)}) {
            Text(text = "This is FirstScreen")
        }
    }
}

