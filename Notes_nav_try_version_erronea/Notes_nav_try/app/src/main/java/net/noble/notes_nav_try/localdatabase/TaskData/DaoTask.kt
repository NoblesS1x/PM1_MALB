package net.noble.notes_nav_try.localdatabase.TaskData

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import net.noble.notes_nav_try.localdatabase.NotesData.Contract
import net.noble.notes_nav_try.localdatabase.NotesData.NotesData

@Dao
interface DaoTask {
    //Insert
    @Insert()
    fun newTask(task: TaskData)

    //ObtenerTodos
    @Query("SELECT * FROM ${net.noble.notes_nav_try.localdatabase.TaskData.Contract.TaskTbl.TABLE_NAME}")
    fun getListTask(): List<TaskData>
    //borrarUno
    @Query("DELETE FROM ${net.noble.notes_nav_try.localdatabase.TaskData.Contract.TaskTbl.TABLE_NAME} WHERE id = :id")
    fun deleteTask(id: String)
}