package net.noble.notes_nav_try

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.room.Room
import net.noble.notes_nav_try.Screens.AddNotes
import net.noble.notes_nav_try.Screens.AddTask
import net.noble.notes_nav_try.Screens.AndroidAudioPlayer
import net.noble.notes_nav_try.Screens.AndroidAudioRecorder
import net.noble.notes_nav_try.Screens.GrabarAudioScreen
import net.noble.notes_nav_try.ui.theme.Notes_nav_tryTheme
import net.noble.notes_nav_try.Screens.Notes
import net.noble.notes_nav_try.ViewModel.ViewModel_Screen_Add_Notes.Add_Notes_ViewModel
import net.noble.notes_nav_try.ViewModel.ViewModel_Screen_Add_Task.Add_Task_ViewModel
import net.noble.notes_nav_try.ViewModel.ViewModel_Screen_Notes.Notes_ViewModel
import net.noble.notes_nav_try.localdatabase.NotesData.Contract
import net.noble.notes_nav_try.localdatabase.NotesData.NoteDB
import java.io.File


class MainActivity : ComponentActivity() {
    object GlobalVars {
        var rectColor = Color(0xFFFFFBFE)
    }
    private val recorder by lazy {
        AndroidAudioRecorder(applicationContext)
    }

    private val player by lazy {
        AndroidAudioPlayer(applicationContext)
    }

    private var audioFile: File? = null


    @RequiresApi(Build.VERSION_CODES.O)
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val db = Room.databaseBuilder(applicationContext, NoteDB::class.java, Contract.DB.NAME).allowMainThreadQueries().build()
        val Notes_ViewModel by viewModels<Notes_ViewModel>()
        val Add_Notes_ViewModel by viewModels<Add_Notes_ViewModel>()
        val Add_Task_ViewModel by viewModels<Add_Task_ViewModel>()
        setContent {
            Notes_nav_tryTheme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = Router.NOTES.route){

                    composable(Router.NOTES.route){
                        Notes(db,navController = navController,Notes_ViewModel)
                    }
                    composable(Router.ADD_Notes.route){
                        AddNotes(db,navController = navController,Add_Notes_ViewModel)
                    }
                    composable(Router.ADD_Task.route){
                        AddTask(navController = navController,Add_Task_ViewModel)
                    }
                }
                /*
                GrabarAudioScreen(
                    onClickStGra = {
                        File(cacheDir, "audio.mp3").also {
                            recorder.start(it)
                            audioFile = it
                        }

                    },
                    onClickSpGra = {recorder.stop()},
                    onClickStRe = { audioFile?.let { player.start(it) } },
                    onClickSpRe = {player.stop()}
                )

                 */
            }

        }
    }


}


