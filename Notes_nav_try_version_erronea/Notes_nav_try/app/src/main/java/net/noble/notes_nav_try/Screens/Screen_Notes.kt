package net.noble.notes_nav_try.Screens

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.app.Dialog
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.drawscope.translate
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import net.noble.notes_nav_try.MainActivity
import net.noble.notes_nav_try.R
import net.noble.notes_nav_try.Router
import net.noble.notes_nav_try.ViewModel.ViewModel_Screen_Notes.Notes_ViewModel
import net.noble.notes_nav_try.WindowInfo
import net.noble.notes_nav_try.localdatabase.NotesData.NoteDB
import net.noble.notes_nav_try.localdatabase.NotesData.NotesData
import net.noble.notes_nav_try.rememberWindowInfo


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "ResourceType")
@ExperimentalMaterial3Api
@Composable
fun Notes(db: NoteDB, navController: NavController, notesVievmodel: Notes_ViewModel) {
    val state = notesVievmodel.state
    var listnote = mutableListOf<NotesData>()
    listnote = db.daoNotes().getListNote().toMutableList()
    val windowInfo = rememberWindowInfo()

    if (windowInfo.screenWidthInfo is WindowInfo.WindowType.Compact) {
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            floatingActionButton = {
                FloatingActionButton(onClick = {
                    MainActivity.GlobalVars.id=-1
                    navController.navigate(Router.ADD_Notes.route)
                }) { Icon(imageVector = Icons.Filled.Add, contentDescription = "") }
            }){

            LazyColumn(modifier = Modifier
                .fillMaxSize()
                .padding(top = 120.dp)){ itemsIndexed(listnote){pos, w ->
                    Card(modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 5.dp, horizontal = 10.dp)
                        .clickable {
                            navController.navigate(Router.ADD_Notes.route)
                            MainActivity.GlobalVars.id = w.id
                        }

                    ){
                        Row{
                            var NoteDesc = remember{ mutableStateOf( false)}
                            var eliminarConfirmaciónrequerida by rememberSaveable { mutableStateOf(false) }
                            Column(modifier = Modifier
                                .fillMaxWidth(0.75f)
                                .padding(horizontal = 5.dp)){
                                Row{
                                    Text(text = stringResource(R.string.titulo))
                                    Text(text ="${w.TiteNote}", maxLines = 1) }

                                Row{
                                    Text(text = stringResource(R.string.fecha))
                                    Text(text ="${w.DateNote}", maxLines = 1) }

                                if(NoteDesc.value){
                                    Column {
                                        Text(text = stringResource(R.string.descripccion))
                                        Text(text = "${w.NoteDescription}") } } }

                            Column {
                                IconButton(onClick = {
                                    NoteDesc.value = !NoteDesc.value
                                }) {
                                    Icon(Icons.Filled.ArrowDropDown, contentDescription = stringResource(
                                        R.string.borrar
                                    ),Modifier.rotate(if(NoteDesc.value)180f else 360f)
                                    ) } }//EndColumn

                            Column {

                                if (eliminarConfirmaciónrequerida) {
                                    mostrarDialogoEliminacion(
                                        confirmarEliminacion = {
                                            db.daoNotes().deleteNote(w.id.toString())
                                            navController.navigate(Router.NOTES.route)
                                            eliminarConfirmaciónrequerida = false },

                                        cancelarEliminacion = { eliminarConfirmaciónrequerida = false })}

                                IconButton(onClick = {
                                    eliminarConfirmaciónrequerida = true
                                }) { Icon(Icons.Outlined.Delete, contentDescription = "Borrar") } }//EndColumn
                        }//EndRow
                    }//EndCard
                }//EndItemsIndexed
            }//EndLazyColumn

            Canvas(modifier = Modifier.fillMaxSize()) {
                translate(left = 0f, top = 0f) {
                    drawRoundRect(
                        color =MainActivity.GlobalVars.rectColor,
                        size = Size(1100f, 320f),
                    ) } }//EndCanvas

            var name by remember { mutableStateOf("") }

            Column(modifier = Modifier
                .padding(5.dp)
                .verticalScroll(rememberScrollState()),
                   horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Top)
            {
                Row {
                    TextField(value = name, onValueChange = {
                        name = it
                    }, modifier = Modifier.width(375.dp),
                        placeholder = { Text(stringResource(R.string.buscar)) }) }//EndRow
            }//EndColumn
            Column(modifier = Modifier
                .padding(65.dp)
                .verticalScroll(rememberScrollState())) {
                Row(verticalAlignment = Alignment.Top,horizontalArrangement = Arrangement.SpaceAround) {
                    Button(onClick = { /*TODO*/ }) { Text(text = "Todo") }
                    Button(onClick = { /*TODO*/ }) { Text(text = "Notas") }
                    Button(onClick = { /*TODO*/ }) { Text(text = "Tareas") }
                }//EndRow
            }//EndColumn

        }//Scaffold
}else{
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            floatingActionButton = {
                FloatingActionButton(onClick = {
                    MainActivity.GlobalVars.id=-1
                    navController.navigate(Router.ADD_Notes.route)
                }) { Icon(imageVector = Icons.Filled.Add, contentDescription = "") }
            }){
            LazyColumn(modifier = Modifier
                .fillMaxSize()
                .padding(top = 120.dp)){ itemsIndexed(listnote){pos, w ->
                Card(modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 5.dp, horizontal = 10.dp)
                    .clickable {
                        navController.navigate(Router.ADD_Notes.route)
                        MainActivity.GlobalVars.id = w.id
                    }

                ){
                    Row{
                        var NoteDesc = remember{ mutableStateOf( false)}
                        var eliminarConfirmaciónrequerida by rememberSaveable { mutableStateOf(false) }
                        Column(modifier = Modifier
                            .fillMaxWidth(0.85f)
                            .padding(horizontal = 5.dp)){
                            Row{
                                Text(text = stringResource(R.string.titulo))
                                Text(text ="${w.TiteNote}", maxLines = 1) }

                            Row{
                                Text(text = stringResource(R.string.fecha))
                                Text(text ="${w.DateNote}", maxLines = 1) }

                            if(NoteDesc.value){
                                Column {
                                    Text(text = stringResource(R.string.descripccion))
                                    Text(text = "${w.NoteDescription}") } } }

                        Column {
                            IconButton(onClick = {
                                NoteDesc.value = !NoteDesc.value
                            }) {
                                Icon(Icons.Filled.ArrowDropDown, contentDescription = stringResource(
                                    R.string.borrar
                                ),Modifier.rotate(if(NoteDesc.value)180f else 360f)
                                ) } }//EndColumn

                        Column {

                            if (eliminarConfirmaciónrequerida) {
                                mostrarDialogoEliminacion(
                                    confirmarEliminacion = {
                                        db.daoNotes().deleteNote(w.id.toString())
                                        navController.navigate(Router.NOTES.route)
                                        eliminarConfirmaciónrequerida = false },

                                    cancelarEliminacion = { eliminarConfirmaciónrequerida = false })}

                            IconButton(onClick = {
                                eliminarConfirmaciónrequerida = true
                            }) { Icon(Icons.Outlined.Delete, contentDescription = "Borrar") } }//EndColumn
                    }//EndRow
                }//EndCard
            }//EndItemsIndexed
        }//EndLazyColumn

            Canvas(modifier = Modifier.fillMaxSize()) {
                translate(left = 0f, top = 0f) {
                    drawRoundRect(
                        color =MainActivity.GlobalVars.rectColor,
                        size = Size(2400f, 320f),
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
                    }, modifier = Modifier.width(835.dp),
                        placeholder = { Text("Buscar") })

                }
            }

                Row(modifier = Modifier.padding(65.dp),
                    verticalAlignment = Alignment.Top,
                    horizontalArrangement = Arrangement.Center
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
            //}

        }//Scaffold

    }

}//finfun


@Composable
private fun mostrarDialogoEliminacion(
    confirmarEliminacion: () -> Unit,
    cancelarEliminacion: () -> Unit,
) {
    AlertDialog(onDismissRequest = {  },
        title = { Text("Confirmar eliminación") },
        text = { Text("¿Estás seguro de que deseas eliminar esta nota?") },
        modifier = Modifier.padding(16.dp),
        dismissButton = {
            TextButton(onClick = cancelarEliminacion  ) {
                Text(text = "Cancelar")
            }
        },
        confirmButton = {
            TextButton(onClick = confirmarEliminacion ) {
                Text(text = "Si, eliminar")
            }
        })
}





