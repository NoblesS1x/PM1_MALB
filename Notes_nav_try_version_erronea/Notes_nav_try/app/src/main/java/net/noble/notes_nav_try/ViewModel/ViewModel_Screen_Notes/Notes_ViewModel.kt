package net.noble.notes_nav_try.ViewModel.ViewModel_Screen_Notes

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.room.Room
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import net.noble.notes_nav_try.MainActivity
import net.noble.notes_nav_try.ViewModel.Note
import net.noble.notes_nav_try.localdatabase.NotesData.Contract
import net.noble.notes_nav_try.localdatabase.NotesData.NoteDB
import net.noble.notes_nav_try.localdatabase.NotesData.NotesData
import net.noble.notes_nav_try.rememberWindowInfo

class Notes_ViewModel() : ViewModel() {
    var state by mutableStateOf(NoteState())
    //private set
    init {

        viewModelScope.launch {

            /*
            state = state.copy(
                isLoading = true
            )
            delay(1000)
            state = state.copy(
                Notes = listOf(
                    Note("Mercado","11-2-2023","Ir al super a realizar la lita de compra semanale para 5 personas: manzanas, jicamas, lechuga, salchichas, jamon, queso"),
                    Note("Mercado","11-2-2023","Ir al super a realizar la lita de compra semanale para 5 personas: manzanas, jicamas, lechuga, salchichas, jamon, queso"),
                    Note("Mercado","11-2-2023","Ir al super a realizar la lita de compra semanale para 5 personas: manzanas, jicamas, lechuga, salchichas, jamon, queso"),
                    Note("Mercado","11-2-2023","Ir al super a realizar la lita de compra semanale para 5 personas: manzanas, jicamas, lechuga, salchichas, jamon, queso"),
                    Note("Mercado","11-2-2023","Ir al super a realizar la lita de compra semanale para 5 personas: manzanas, jicamas, lechuga, salchichas, jamon, queso"),
                    Note("Mercado","11-2-2023","Ir al super a realizar la lita de compra semanale para 5 personas: manzanas, jicamas, lechuga, salchichas, jamon, queso"),
                ),
                isLoading = false
            )*/

        }
    }
}