package net.noble.notes_nav_try.Screens.ViewModel_Screen_Notes

import net.noble.notes_nav_try.Screens.ViewModel_Screen_Notes.Note

data class NoteState(
    val Notes: List<Note> = listOf(),
    val isLoading: Boolean = false
)
