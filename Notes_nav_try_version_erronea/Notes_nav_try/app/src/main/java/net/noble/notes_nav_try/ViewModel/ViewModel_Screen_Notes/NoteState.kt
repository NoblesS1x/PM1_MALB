package net.noble.notes_nav_try.ViewModel.ViewModel_Screen_Notes

import net.noble.notes_nav_try.ViewModel.Note

data class NoteState(
    val Notes: List<Note> = listOf(),
    val isLoading: Boolean = false
)
