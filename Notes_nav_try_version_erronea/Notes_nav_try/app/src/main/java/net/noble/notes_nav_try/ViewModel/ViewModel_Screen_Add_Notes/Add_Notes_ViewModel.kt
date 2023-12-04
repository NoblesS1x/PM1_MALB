package net.noble.notes_nav_try.ViewModel.ViewModel_Screen_Add_Notes

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import net.noble.notes_nav_try.ViewModel.Note
import net.noble.notes_nav_try.ViewModel.ViewModel_Screen_Notes.NoteState

class Add_Notes_ViewModel : ViewModel(){
    var state by mutableStateOf(NoteState())
        private set
    init {
        viewModelScope.launch {
            state = state.copy(
                Notes = listOf(
                    Note("Mercado","11-2-2023","Ir al super a realizar la lita de compra semanale para 5 personas: manzanas, jicamas, lechuga, salchichas, jamon, queso"),
                    Note("Mercado","11-2-2023","Ir al super a realizar la lita de compra semanale para 5 personas: manzanas, jicamas, lechuga, salchichas, jamon, queso"),
                    Note("Mercado","11-2-2023","Ir al super a realizar la lita de compra semanale para 5 personas: manzanas, jicamas, lechuga, salchichas, jamon, queso"),
                    Note("Mercado","11-2-2023","Ir al super a realizar la lita de compra semanale para 5 personas: manzanas, jicamas, lechuga, salchichas, jamon, queso"),
                    Note("Mercado","11-2-2023","Ir al super a realizar la lita de compra semanale para 5 personas: manzanas, jicamas, lechuga, salchichas, jamon, queso"),
                    Note("Mercado","11-2-2023","Ir al super a realizar la lita de compra semanale para 5 personas: manzanas, jicamas, lechuga, salchichas, jamon, queso"),
                ))
        }
    }

}