package net.noble.notes_nav_try.localdatabase.NotesData

import androidx.room.Database
import androidx.room.RoomDatabase
import net.noble.notes_nav_try.localdatabase.NotesData.DaoNotes
import net.noble.notes_nav_try.localdatabase.NotesData.NotesData

@Database(

    entities = [
        NotesData::class
    ],
    version = 1,
    exportSchema = true
)
abstract class NoteDB: RoomDatabase() {
    abstract fun daoNotes(): DaoNotes
}