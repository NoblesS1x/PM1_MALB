package net.noble.notes_nav_try.localdatabase.NotesData

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface DaoNotes {
    //Insert
    @Insert()
    fun newNote(note: NotesData)

    //ObtenerTodos
    @Query("SELECT * FROM ${Contract.NotesTbl.TABLE_NAME}")
    fun getListNote(): List<NotesData>
    //ObtenerUno
}