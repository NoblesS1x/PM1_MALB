package net.noble.notes_nav_try.localdatabase.TaskData

import androidx.room.Database
import androidx.room.RoomDatabase
import net.noble.notes_nav_try.localdatabase.NotesData.NotesData


@Database(

    entities = [
        TaskData::class
    ],
    version = 1,
    exportSchema = true
)
abstract class TaskDB: RoomDatabase() {
    abstract fun daoTask(): DaoTask
}
