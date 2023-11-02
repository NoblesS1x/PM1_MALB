package net.noble.notes_view_try.ViewModel_Screen_Notes

data class NoteState(
    val Notes: List<Note> = listOf(),
    val isLoading: Boolean = false
)
