package net.noble.notes_nav_try.Screens

import android.annotation.SuppressLint
import android.net.Uri
import android.os.Build
import android.util.Log
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SheetValue
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.navigation.NavController
import net.noble.notes_nav_try.Router
import net.noble.notes_nav_try.ViewModel.ViewModel_Screen_Add_Notes.Add_Notes_ViewModel
import net.noble.notes_nav_try.WindowInfo
import net.noble.notes_nav_try.localdatabase.NotesData.NoteDB
import net.noble.notes_nav_try.localdatabase.NotesData.NotesData
import net.noble.notes_nav_try.rememberWindowInfo
import java.time.LocalDateTime



@RequiresApi(Build.VERSION_CODES.O)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddNotes(db: NoteDB, navController: NavController, addNotesViewmodel: Add_Notes_ViewModel) {
    val state = addNotesViewmodel.state
    val windowInfo = rememberWindowInfo()
    var name by remember { mutableStateOf("") }
    var date = LocalDateTime.now()
    var description by remember { mutableStateOf("") }

    val c = LocalContext.current
    //val db = Room.databaseBuilder(c,NoteDB::class.java,Contract.DB.NAME).allowMainThreadQueries().build()
    //val db = Room.databaseBuilder(context,NoteDB::class.java,Contract.DB.NAME).build()
    val DaoN =db.daoNotes()

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
                        placeholder = { Text("Titulo de nota") })
                }
                Row(Modifier.padding(vertical = 10.dp)) {
                    Text(text = date.toString())
                    //Text(text = "Hora de la nota")
                }

                Row (Modifier.padding(vertical = 10.dp)){
                    TextField(value = description,
                        onValueChange = {
                            description = it
                        },
                        maxLines = 10,
                        modifier = Modifier.width(375.dp),
                        placeholder = { Text("Description") })
                }
                Row(Modifier.padding(vertical = 10.dp)) {
                    Button(onClick = {
                        val n = NotesData(0, TiteNote = name, DateNote = date.toString(), NoteDescription = description)
                        DaoN.newNote(n)
                        Toast.makeText( c,"Nota guardada", Toast.LENGTH_SHORT).show()
                        navController.popBackStack()

                    }) {
                        Text(text = "Guardar Nota")
                    }
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
                Row(Modifier.padding(vertical = 10.dp)) {
                    Text(text = date.toString())
                    //Text(text = "Hora de la nota")
                }

                Row{
                    TextField(value = description, onValueChange = {
                        description = it},maxLines = 3,modifier = Modifier.width(775.dp)
                        , placeholder = { Text("Description") })

                }
                Row(Modifier.padding(vertical = 10.dp)) {
                    Button(onClick = {
                        val n = NotesData(0, TiteNote = name, DateNote = date.toString(), NoteDescription = description)
                        DaoN.newNote(n)
                        Toast.makeText( c,"Nota guardada", Toast.LENGTH_SHORT).show()
                        navController.popBackStack()

                    }) {
                        Text(text = "Guardar Nota")
                    }
                }

            }

        }
    }
}
