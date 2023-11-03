package net.noble.notes_nav_try.Screens.ViewModel_Screen_Notes

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class Notes_ViewModel : ViewModel() {
    var state by mutableStateOf(NoteState())
        private set
    init {
        viewModelScope.launch {
            state = state.copy(
                isLoading = true
            )
            delay(1000)
            state = state.copy(
                Notes = listOf(
                    Note("Mercado","11-2-2023","Ir al super"),
                    Note("Mercado","11-2-2023","Ir al super"),
                    Note("Mercado","11-2-2023","Ir al super"),
                    Note("Mercado","11-2-2023","Ir al super"),
                    Note("Mercado","11-2-2023","Ir al super"),
                    Note("Mercado","11-2-2023","Ir al super"),
                    Note("Mercado","11-2-2023","Ir al super"),
                    Note("Mercado","11-2-2023","Ir al super"),
                    Note("Mercado","11-2-2023","Ir al super"),
                    Note("Mercado","11-2-2023","Ir al super"),
                    Note("Mercado","11-2-2023","Ir al super"),
                    Note("Mercado","11-2-2023","Ir al super"),
                    Note("Mercado","11-2-2023","Ir al super"),
                    Note("Mercado","11-2-2023","Ir al super"),
                    Note("Mercado","11-2-2023","Ir al super"),
                    Note("Mercado","11-2-2023","Ir al super"),
                    Note("Mercado","11-2-2023","Ir al super"),
                    Note("Mercado","11-2-2023","Ir al super"),
                    Note("Mercado","11-2-2023","Ir al super"),
                    Note("Mercado","11-2-2023","Ir al super"),
                    Note("Mercado","11-2-2023","Ir al super"),
                    Note("Mercado","11-2-2023","Ir al super"),
                    Note("Mercado","11-2-2023","Ir al super"),
                    Note("Mercado","11-2-2023","Ir al super"),
                    Note("Mercado","11-2-2023","Ir al super"),
                    Note("Mercado","11-2-2023","Ir al super"),
                ),
                isLoading = false
            )

        }
    }
}