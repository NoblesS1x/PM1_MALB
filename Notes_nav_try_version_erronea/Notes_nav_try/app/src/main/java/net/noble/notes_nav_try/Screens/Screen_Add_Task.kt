package net.noble.notes_nav_try.Screens

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TimeInput
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberTimePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import net.noble.notes_nav_try.MainActivity
import net.noble.notes_nav_try.Notificacion.TaskAlarm
import net.noble.notes_nav_try.Notificacion.createChannelNotification
import net.noble.notes_nav_try.R
import net.noble.notes_nav_try.Router
import net.noble.notes_nav_try.ViewModel.ViewModel_Screen_Add_Task.Add_Task_ViewModel
import net.noble.notes_nav_try.WindowInfo
import net.noble.notes_nav_try.localdatabase.NotesData.NotesData
import net.noble.notes_nav_try.localdatabase.TaskData.TaskDB
import net.noble.notes_nav_try.localdatabase.TaskData.TaskData
import net.noble.notes_nav_try.rememberWindowInfo
import java.time.LocalDateTime
import java.time.LocalTime

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddTask(dbt: TaskDB, navController: NavController, addTaskViewmodel: Add_Task_ViewModel) {
    val c = LocalContext.current
    LaunchedEffect(Unit){
        createChannelNotification("Tareas",c)
    }
    val state1 = rememberTimePickerState()
    val state = addTaskViewmodel.state
    val l = LocalContext.current
    val windowInfo = rememberWindowInfo()
    var name by remember { mutableStateOf("") }
    var date = LocalDateTime.now()
    var ld = LocalTime.of(state1.hour, state1.minute)
    var time = LocalTime.now()
    var description by remember { mutableStateOf("") }
    var title = stringResource(R.string.nueva_tarea)

    if (windowInfo.screenWidthInfo is WindowInfo.WindowType.Compact) {
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            topBar = {
                TopAppBar(
                    title = {
                        Text(
                            modifier = Modifier.padding(start = 80.dp),
                            textAlign = TextAlign.Center,
                            text = title
                        )
                    },
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
            },
            bottomBar = {

                BottomAppBar(
                ) {
                    Spacer(modifier = Modifier.size(22.dp))
                    Button(onClick = {
                        if (MainActivity.GlobalVars.id != -1) {
                            MainActivity.GlobalVars.id = -1
                            //navController.navigate(Router.NOTES.route)
                            navController.popBackStack()
                        } else {

                            val r = TaskData(id = 0, TiteTask = name, DateTask = date.toString(), TaskDescription = description)
                            TaskAlarm(context = c, expiration = ld,r)
                            //dbt.daoTask().newTask(r)
                            Toast.makeText(c, "Tarea guardada", Toast.LENGTH_SHORT).show()
                            navController.popBackStack()
                        }
                    }) {
                        Icon(
                            Icons.Default.Done,
                            contentDescription = stringResource(R.string.guardar_nota)
                        )
                        Text(text = stringResource(R.string.guardar))
                    }
                }

            }

        ) {
            Column(
                modifier = Modifier
                    .padding(60.dp)
                    .verticalScroll(rememberScrollState()),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top
            ) {

                Row {
                    TextField(value = name, onValueChange = {
                        name = it
                    }, maxLines = 1, modifier = Modifier.width(375.dp),
                        placeholder = { Text(stringResource(R.string.titulo_de_tarea)) })
                }
                Row(Modifier.padding(vertical = 10.dp)) {
                    Text(text = date.toString())
                    //Text(text = "Hora de la nota")
                }

                Row(Modifier.padding(vertical = 10.dp)) {
                    TextField(value = description,
                        onValueChange = {
                            description = it
                        },
                        maxLines = 10,
                        modifier = Modifier.width(375.dp),
                        placeholder = { Text(stringResource(R.string.descripcion)) })
                }
                Row(modifier = Modifier.fillMaxSize()){

                    Column{
                        TimeInput(
                            state = state1,
                            modifier = Modifier.padding(16.dp)
                        )
                    }
                }

            }
        }
    } else {
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            topBar = {
                TopAppBar(
                    title = {
                        Text(
                            modifier = Modifier.padding(start = 80.dp),
                            textAlign = TextAlign.Center,
                            text = title
                        )
                    },
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
            },
            bottomBar = {

                BottomAppBar(
                ) {
                    Spacer(modifier = Modifier.size(22.dp))
                    Button(onClick = {
                        if (MainActivity.GlobalVars.id != -1) {
                            MainActivity.GlobalVars.id = -1
                            //navController.navigate(Router.NOTES.route)
                            navController.popBackStack()
                        } else {
                            Toast.makeText(c, "Tarea guardada", Toast.LENGTH_SHORT).show()
                            navController.popBackStack()
                        }
                    }) {
                        Icon(
                            Icons.Default.Done,
                            contentDescription = stringResource(R.string.guardar_nota)
                        )
                        Text(text = stringResource(R.string.guardar))
                    }
                }

            }

        ) {
        }
    }
}

