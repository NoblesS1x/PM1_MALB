package net.noble.notas_nav.screens
/*
import android.annotation.SuppressLint
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.ScaffoldDefaults
import androidx.compose.runtime.Composable
*/
import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import net.noble.notas_nav.navigation.AppScreens

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FirstScreen(navController: NavController ){
    Scaffold {
        FirstBodyConten(navController)
    }
}
@Composable
fun FirstBodyConten(navController: NavController){
    Column (
        modifier= Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment =  Alignment.CenterHorizontally
    ){
        Text(text = "This is FirstScreen")
        Button(onClick = { navController.navigate(route = AppScreens.SecondScreen.route)}) {
            Text(text = "This is SecondScreen")
        }
    }
}
/*
@Preview(showBackground = true)
@Composable
fun FirstDefaultPreview(){
    FirstScreen()
}
 */