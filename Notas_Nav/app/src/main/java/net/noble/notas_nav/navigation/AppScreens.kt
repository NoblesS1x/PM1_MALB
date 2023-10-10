package net.noble.notas_nav.navigation
import net.noble.notas_nav.screens.FirstScreen
import net.noble.notas_nav.screens.SecondScreen

sealed class AppScreens(val route: String){
     object FirstScreen: AppScreens("first_screen")
    object SecondScreen: AppScreens("second_screen")
}