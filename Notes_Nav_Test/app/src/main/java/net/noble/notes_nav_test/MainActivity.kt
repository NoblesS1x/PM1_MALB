package net.noble.notes_nav_test

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import net.noble.notes_nav_test.ui.theme.Notes_Nav_TestTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Notes_Nav_TestTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navigationController = rememberNavController()
                    NavHost(navController = navigationController, startDestination = Routes.PantallaUno.route)
                    //NavHost(navController = navigationController, startDestination = Routes.PantallaUno.route)
                        composable(Routes.PantallaUno.route){ Routes.PantallaUno(navController = navigationController) }
                        composable(Routes.PantallaDos.route){ Routes.PantallaDos(navController = navigationController)}
                        composable(Routes.PantallaTres.route){ (navController = navigationController)}
                }
            }
        }
    }
}

