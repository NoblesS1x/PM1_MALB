package net.noble.notes_nav_try.Screens

import android.annotation.SuppressLint
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.translate
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import net.noble.notes_nav_try.Router

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@ExperimentalMaterial3Api
@Composable
        /*
        Scaffold(
            floatingActionButton = {
                MultiFloatingActionButton(fabIcon = painterResource(id = R.drawable.ic_fab_add),
                    items = arrayListOf(FabItem(icon =  painterResource(id = R.drawable.ic_fab_add), label = "Button 1") {
                        Toast.makeText(applicationContext,"Floating Button clicked",Toast.LENGTH_LONG).show()
                    }))

            }
        )
         */
fun Notes(navController: NavController) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        floatingActionButton = {
            FloatingActionButton(onClick = {navController.navigate(Router.ADD_Notes.route)}) {
               Icon(imageVector = Icons.Filled.Add, contentDescription = "")
            }
        }//floating button
    ) {

        var name by remember {
            mutableStateOf("")
        }
        Column(
            modifier = Modifier
                .padding(5.dp)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            Row {
                TextField(value = name, onValueChange = {
                    name = it
                }, modifier = Modifier.width(375.dp),
                    placeholder = { Text("Buscar") })

            }
        }

        Column(
            modifier = Modifier/*Modifier.fillMaxSize()*//*Modifier.size(250.dp, 100.dp)*//*Modifier*/
                .padding(65.dp)
                .verticalScroll(rememberScrollState()),
        ) {
            Row(
                verticalAlignment = Alignment.Top,
                //horizontalArrangement = Arrangement.spacedBy(space = 1.dp)
                //horizontalArrangement = Arrangement.SpaceBetween
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                Button(onClick = { /*TODO*/ }) {
                    Text(text = "Todo")
                }
                Button(onClick = { /*TODO*/ }) {
                    Text(text = "Notas")
                }
                Button(onClick = { /*TODO*/ }) {
                    Text(text = "Tareas")
                }
            }
        }


        Canvas(modifier = Modifier.size(200.dp, 100.dp)/*Modifier.fillMaxSize()*/) {
            val rectColor = Color.LightGray
            val rectSize = Size(950f, 200f)
            val rectTopLeft = Offset(50f, 50f)

            val espace = 270f
            val marg = 15f


            //drawIntoCanvas { canvas ->
            translate(left = marg, top = espace) {
                drawRoundRect(
                    color = rectColor,
                    topLeft = rectTopLeft,
                    size = rectSize,
                    cornerRadius = CornerRadius(16.dp.toPx(), 16.dp.toPx())
                )
            }
            translate(left = marg, top = (espace * 2)) {
                drawRoundRect(
                    color = rectColor,
                    topLeft = rectTopLeft,
                    size = rectSize,
                    cornerRadius = CornerRadius(16.dp.toPx(), 16.dp.toPx())
                )
            }

            translate(left = marg, top = (espace * 3)) {
                drawRoundRect(
                    color = rectColor,
                    topLeft = rectTopLeft,
                    size = rectSize,
                    cornerRadius = CornerRadius(16.dp.toPx(), 16.dp.toPx())
                )
            }

            translate(left = marg, top = (espace * 4)) {
                drawRoundRect(
                    color = rectColor,
                    topLeft = rectTopLeft,
                    size = rectSize,
                    cornerRadius = CornerRadius(16.dp.toPx(), 16.dp.toPx())
                )
            }

            translate(left = marg, top = (espace * 5)) {
                drawRoundRect(
                    color = rectColor,
                    topLeft = rectTopLeft,
                    size = rectSize,
                    cornerRadius = CornerRadius(16.dp.toPx(), 16.dp.toPx())
                )
            }

            translate(left = marg, top = (espace * 6)) {
                drawRoundRect(
                    color = rectColor,
                    topLeft = rectTopLeft,
                    size = rectSize,
                    cornerRadius = CornerRadius(16.dp.toPx(), 16.dp.toPx())
                )
            }
            /*
            translate(left = marg, top = (espace * 7)) {
                drawRoundRect(
                    color = rectColor,
                    topLeft = rectTopLeft,
                    size = rectSize,
                    cornerRadius = CornerRadius(16.dp.toPx(), 16.dp.toPx())
                )
            }
             */
        }
        /*
        Column(
            modifier = Modifier
                .padding(5.dp)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.End,
            verticalArrangement = Arrangement.Center
        ) {
            Button(onClick = { navController.navigate(Router.ADD_Notes.route) }) {
                Text(text = "+")
            }

        }

         */

    }//Scaffold
}//finfun

/*
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AppTheme {
        Greeting("Android")
    }
}
 */