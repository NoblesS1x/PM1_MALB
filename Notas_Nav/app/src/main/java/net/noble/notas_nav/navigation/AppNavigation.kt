package net.noble.notas_nav.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import net.noble.notas_nav.screens.FirstScreen
import net.noble.notas_nav.screens.SecondScreen
import net.noble.notas_nav.navigation.AppScreens

@Composable
fun AppNavigation(){
val navController = rememberNavController()
    NavHost(navController = navController, startDestination = AppScreens.FirstScreen.route ){
        composable(route = AppScreens.FirstScreen.route){
            FirstScreen(navController)
        }
        composable(route = AppScreens.FirstScreen.route){
            SecondScreen(navController)
        }
    }
}