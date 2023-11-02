package net.noble.notes_nav_try.Screens.ViewModel_Screen_Add_Notes

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import net.noble.notes_nav_try.Screens.ViewModel_Screen_Notes.Note
import net.noble.notes_nav_try.Screens.ViewModel_Screen_Notes.NoteState

class Add_Notes_ViewModel : ViewModel(){
    var state by mutableStateOf(NoteState())
        private set
    init {
        viewModelScope.launch {


        }
    }

}