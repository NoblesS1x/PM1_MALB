package net.noble.notes_nav_try

sealed class Router(val route: String){
    object NOTES: Router("Screen_Notes")
    object ADD_Notes: Router("Screen_Add_Notes")
    object ADD_Task: Router("Screen_Add_Task")
}
