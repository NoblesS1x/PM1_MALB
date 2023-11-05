package net.noble.notes_nav_try.Screens

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
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
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.HorizontalAlignmentLine
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import net.noble.notes_nav_try.Router
import net.noble.notes_nav_try.Screens.ViewModel_Screen_Add_Notes.Add_Notes_ViewModel
import net.noble.notes_nav_try.Screens.ViewModel_Screen_Notes.Notes_ViewModel
import net.noble.notes_nav_try.WindowInfo
import net.noble.notes_nav_try.rememberWindowInfo

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddNotes(navController: NavController,addNotesViewmodel: Add_Notes_ViewModel) {
    val state = addNotesViewmodel.state

    val windowInfo = rememberWindowInfo()
    if (windowInfo.screenWidthInfo is WindowInfo.WindowType.Compact) {
        Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title ={ Text(
                    modifier = Modifier.padding(start = 80.dp), textAlign = TextAlign.Center,
                    text = "Nueva Nota")},
                navigationIcon = {
                    Icon(
                        modifier = Modifier
                            .size(50.dp)
                            .clickable {
                                navController.navigate(Router.NOTES.route)
                            },
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = "",
                    )
                })
        }
    ){
        var name by remember {
            mutableStateOf("")
        }

        Column(
            modifier = Modifier
                .padding(60.dp)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {

            Row{
                TextField(value = name, onValueChange = {
                    name = it},maxLines = 1,modifier = Modifier.width(375.dp),
                    placeholder = { Text("Titulo de nota") })
            }
            Row{
                Text("Hora y fecha nota")
                //Text(text = "Hora de la nota")
            }

            Row{
                var description by remember{
                    mutableStateOf("")
                }
                TextField(value = description, onValueChange = {
                    description = it},maxLines = 15,modifier = Modifier.width(375.dp)
                    , placeholder = { Text("Description") })

                }
            }
        }

    }else{
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            topBar = {
                TopAppBar(
                    title ={ Text(
                        modifier = Modifier.padding(start = 80.dp), textAlign = TextAlign.Center,
                        text = "Nueva Nota")},
                    navigationIcon = {
                        Icon(
                            modifier = Modifier
                                .size(50.dp)
                                .clickable {
                                    navController.navigate(Router.NOTES.route)
                                },
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = "",
                        )
                    })
            }
        ){
            var name by remember {
                mutableStateOf("")
            }

            Column(
                modifier = Modifier
                    .padding(60.dp)
                    .verticalScroll(rememberScrollState()),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top
            ) {

                Row{
                    TextField(value = name, onValueChange = {
                        name = it},maxLines = 1,modifier = Modifier.width(775.dp),
                        placeholder = { Text("Titulo de nota") })
                }
                Row{
                    Text("Hora y fecha nota")
                    //Text(text = "Hora de la nota")
                }

                Row{
                    var description by remember{
                        mutableStateOf("")
                    }
                    TextField(value = description, onValueChange = {
                        description = it},maxLines = 6,modifier = Modifier.width(775.dp)
                        , placeholder = { Text("Description") })

                }
            }
        }
    }
}