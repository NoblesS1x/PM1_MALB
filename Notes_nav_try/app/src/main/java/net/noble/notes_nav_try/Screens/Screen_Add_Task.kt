package net.noble.notes_nav_try.Screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import net.noble.notes_nav_try.Screens.ViewModel_Screen_Add_Task.Add_Task_ViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddTask(navController: NavController,addTaskViewmodel: Add_Task_ViewModel) {
    val state = addTaskViewmodel.state
    var name by remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier
            .padding(30.dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {

        Row{
            TextField(value = name, onValueChange = {
                name = it },maxLines = 1,modifier = Modifier.width(325.dp),
                placeholder = { Text("Titulo de tarea") })
        }
        Row{
            Text("Hora y fecha tarea")
            //Text(text = "Hora de la nota")
        }

        Row{
            var description by remember{
                mutableStateOf("")
            }
            TextField(value = description, onValueChange = {
                description = it},maxLines = 15,modifier = Modifier.width(325.dp)
                , placeholder = { Text("Description") })
        }


    }
}
