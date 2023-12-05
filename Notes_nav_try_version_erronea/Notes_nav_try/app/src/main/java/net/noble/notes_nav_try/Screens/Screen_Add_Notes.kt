package net.noble.notes_nav_try.Screens

import net.noble.notes_nav_try.Multimedia.ComposeFileProvider
import android.annotation.SuppressLint
import android.net.Uri
import android.os.Build
import android.util.Log
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresApi
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
import androidx.compose.material.icons.filled.Camera
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Image
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Videocam
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.ui.PlayerView
import net.noble.notes_nav_try.MainActivity
import net.noble.notes_nav_try.Router
import net.noble.notes_nav_try.ViewModel.ViewModel_Screen_Add_Notes.Add_Notes_ViewModel
import net.noble.notes_nav_try.WindowInfo
import net.noble.notes_nav_try.localdatabase.NotesData.NoteDB
import net.noble.notes_nav_try.localdatabase.NotesData.NotesData
import net.noble.notes_nav_try.rememberWindowInfo
import java.time.LocalDateTime



@RequiresApi(Build.VERSION_CODES.S)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddNotes(db: NoteDB, navController: NavController, addNotesViewmodel: Add_Notes_ViewModel) {
    val state = addNotesViewmodel.state
    val windowInfo = rememberWindowInfo()
    var name by remember { mutableStateOf("") }
    var date = LocalDateTime.now()
    var description by remember { mutableStateOf("") }

    if(MainActivity.GlobalVars.id !=-1){
        val NotesData = db.daoNotes().getOne(MainActivity.GlobalVars.id.toString())
     name = NotesData.TiteNote
     description = NotesData.NoteDescription
    }
    val c = LocalContext.current
    val DaoN =db.daoNotes()
    var showBottomSheet by remember { mutableStateOf(false) }
    val sheetState = rememberModalBottomSheetState()

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
        },
            bottomBar = {

                BottomAppBar(

                    //containerColor = MaterialTheme.colorScheme.primaryContainer,
                    //contentColor = MaterialTheme.colorScheme.primary,
                ) {
                    Row {
                        Button(onClick = {showBottomSheet = true}) {
                            Icon(Icons.Default.Add , contentDescription = "Add Imagen")
                            Text(text = "Img")
                        }
                        Spacer(modifier = Modifier.size(22.dp))
                        Button(onClick = {
                            if(MainActivity.GlobalVars.id !=-1){
                                DaoN.updateNote(MainActivity.GlobalVars.id.toString(),name,date.toString(),description)
                                Toast.makeText( c,"Nota actualizada", Toast.LENGTH_SHORT).show()
                                MainActivity.GlobalVars.id = -1
                                //navController.navigate(Router.NOTES.route)
                                navController.popBackStack()
                            }else{
                                val n = NotesData(0, TiteNote = name, DateNote = date.toString(), NoteDescription = description)
                                DaoN.newNote(n)
                                Toast.makeText( c,"Nota guardada", Toast.LENGTH_SHORT).show()
                                navController.popBackStack()
                            }
                        }) {
                            Icon(Icons.Default.Done , contentDescription = "Save note")
                            Text(text = "Guardar")
                        }
                    }
                }
            }
    ) {innerPadding ->
            Column(
                modifier = Modifier
                    .padding(innerPadding),
                verticalArrangement = Arrangement.spacedBy(16.dp),
            ) {

            }

            // Screen content
            if (showBottomSheet) {
                ModalBottomSheet(
                    onDismissRequest = {
                        showBottomSheet = false
                    },
                    sheetState = sheetState
                ) {

                    var uri : Uri? = null
                    // 1
                    var hasImage by remember {
                        mutableStateOf(false)
                    }
                    var hasVideo by remember {
                        mutableStateOf(false)
                    }
                    // 2
                    var imageUri by remember {
                        mutableStateOf<Uri?>(null)
                    }


                    val imagePicker = rememberLauncherForActivityResult(
                        contract = ActivityResultContracts.GetContent(),
                        onResult = { uri ->
                            // TODO
                            // 3
                            hasImage = uri != null
                            imageUri = uri
                        }
                    )

                    val cameraLauncher = rememberLauncherForActivityResult(
                        contract = ActivityResultContracts.TakePicture(),
                        onResult = { success ->
                            Log.d("IMG", hasImage.toString())
                            Log.d("URI", imageUri.toString())
                            if(success) imageUri = uri
                            hasImage = success
                        }
                    )

                    val videoLauncher = rememberLauncherForActivityResult(
                        contract = ActivityResultContracts.CaptureVideo(),
                        onResult = { success ->
                            hasVideo = success
                        }
                    )

                    Box{}
                    val context = LocalContext.current

                    if ((hasImage or hasVideo) && imageUri != null) {
                        // 5
                        if(hasImage){
                            AsyncImage(
                                model = imageUri,
                                modifier = Modifier.fillMaxWidth(),
                                contentDescription = "Selected image",
                            )
                        }
                        if(hasVideo) {VideoPlayer(videoUri = imageUri!!)}
                    }
                    Row {
                        Spacer(modifier = Modifier.size(60.dp))
                        Button(onClick = {
                            uri = ComposeFileProvider.getImageUri(context)
                            cameraLauncher.launch(uri)}
                        ) {
                            Icon(imageVector = Icons.Default.Camera, contentDescription = "Camera Button")
                        }
                        Spacer(modifier = Modifier.size(30.dp))
                        Button(onClick = {imagePicker.launch("image/*")}) {
                            Icon(imageVector = Icons.Default.Image, contentDescription = "Galery Button")
                        }
                        Spacer(modifier = Modifier.size(30.dp))
                        Button(
                            onClick = {
                                val uri = ComposeFileProvider.getImageUri(context)
                                videoLauncher.launch(uri)
                                imageUri = uri
                            },
                        ) {
                            Icon(imageVector = Icons.Default.Videocam, contentDescription = "Vidio Button")
                        }
                        Spacer(modifier = Modifier.size(30.dp))
                    }
                    // Sheet content
                    Spacer(modifier = Modifier.size(50.dp))
                }
            }


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

@Composable
fun VideoPlayer(videoUri: Uri, modifier: Modifier = Modifier.fillMaxWidth()) {
    val context = LocalContext.current
    val exoPlayer = remember {
        SimpleExoPlayer.Builder(context).build().apply {
            setMediaItem(MediaItem.fromUri(videoUri))
            prepare()
        }
    }
    val playbackState = exoPlayer
    val isPlaying = playbackState?.isPlaying ?: false

    AndroidView(
        factory = { context ->
            PlayerView(context).apply {
                player = exoPlayer
            }
        },
        modifier = modifier
    )

    IconButton(
        onClick = {
            if (isPlaying) {
                exoPlayer.pause()
            } else {
                exoPlayer.play()
            }
        },
        modifier = Modifier
            //.align(Alignment.BottomEnd)
            .padding(16.dp)
    ) {
        Icon(
            imageVector = if (isPlaying) Icons.Filled.Refresh else Icons.Filled.PlayArrow,
            contentDescription = if (isPlaying) "Pause" else "Play",
            tint = Color.White,
            modifier = Modifier.size(48.dp)
        )
    }
}
