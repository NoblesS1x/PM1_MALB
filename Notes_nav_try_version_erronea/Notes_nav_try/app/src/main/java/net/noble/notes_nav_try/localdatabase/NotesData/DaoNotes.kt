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
    @Query("SELECT * FROM ${Contract.NotesTbl.TABLE_NAME} WHERE id = :id")
    fun getOne(id: String): NotesData

    //Borrar uno
    @Query("DELETE FROM ${Contract.NotesTbl.TABLE_NAME} WHERE id = :id")
    fun deleteNote(id: String)
    //update
    @Query("UPDATE ${Contract.NotesTbl.TABLE_NAME} SET TiteNote = :Tite,DateNote = :Date,NoteDescription = :Desc,UriPicture = :Picture, UriVideo= :Video,UriAudio= :Audio WHERE id= :id" )
    fun updateNote(id: String,Tite: String,Date:String,Desc: String,Picture: String,Video: String,Audio: String)
    //Buscar coincidencia

    @Query("SELECT * FROM ${Contract.NotesTbl.TABLE_NAME} WHERE TiteNote LIKE :TiteNote")
    fun coincidencia(TiteNote: String):List<NotesData>
}