package net.noble.notes_nav_try

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import net.noble.notes_nav_try.Screens.AddNotes
import net.noble.notes_nav_try.ui.theme.Notes_nav_tryTheme
import net.noble.notes_nav_try.Screens.Notes

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Notes_nav_tryTheme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = Router.NOTES.route){

                    composable(Router.NOTES.route){
                        Notes(navController = navController)
                    }
                    composable(Router.ADD_Notes.route){
                        AddNotes(navController = navController)
                    }
                }

            }
        }
    }


}


