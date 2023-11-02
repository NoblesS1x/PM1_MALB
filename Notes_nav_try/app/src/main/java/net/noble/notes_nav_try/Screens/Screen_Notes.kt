package net.noble.notes_nav_try.Screens

import android.annotation.SuppressLint
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
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
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.drawscope.translate
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import net.noble.notes_nav_try.MainActivity
import net.noble.notes_nav_try.Router
import net.noble.notes_nav_try.Screens.ViewModel_Screen_Notes.Notes_ViewModel


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@ExperimentalMaterial3Api
@Composable
fun Notes(navController: NavController,notesVievmodel: Notes_ViewModel) {
    val state = notesVievmodel.state
    if(state.isLoading) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            CircularProgressIndicator()
        }
    }
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        floatingActionButton = {
            FloatingActionButton(onClick = {navController.navigate(Router.ADD_Notes.route)}) {
                Icon(imageVector = Icons.Filled.Add, contentDescription = "")
            }
        }//floating button
    ) {
        LazyColumn(
            modifier = Modifier.size(400.dp, 800.dp),
            contentPadding = PaddingValues(
                top = 115.dp,
                bottom =  115.dp)
        ) {
            items(state.Notes){
                Column(modifier = Modifier.padding( start = 15.dp, end = 15.dp), verticalArrangement = Arrangement.Center){
                    Text(text = it.TitleNote)
                    Text(text = it.NoteDate)
                    Divider()
                }
            }
        }

        Canvas(modifier = Modifier.fillMaxSize()) {


            translate(left = 0f, top = 0f) {
                drawRoundRect(
                    color =MainActivity.GlobalVars.rectColor,
                    size = Size(1100f, 320f),
                )
            }
        }
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

        /*
        LazyColumn(
            modifier = Modifier.padding(start = 24.dp, end = 24.dp),
            contentPadding = PaddingValues(horizontal = 15.dp, vertical = 110.dp)
        ){
         */
        /*
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(12.dp),
            contentPadding = PaddingValues(
                top = 110.dp,
                bottom =  24.dp
            )){
            */
        /*
        LazyColumn(
            modifier = Modifier.heightIn(min = 100.dp, max = 600.dp),
            contentPadding = PaddingValues(
                top = 110.dp,
                bottom =  24.dp)
        ) {
         */
        /*
        LazyColumn(
            modifier = Modifier.size(400.dp, 800.dp),
            contentPadding = PaddingValues(
                top = 110.dp,
                bottom =  24.dp)
        ) {
        */




    }//Scaffold
    }//finfun

