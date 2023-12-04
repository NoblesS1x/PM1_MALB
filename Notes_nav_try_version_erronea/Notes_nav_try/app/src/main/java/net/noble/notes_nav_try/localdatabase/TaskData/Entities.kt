package net.noble.notes_nav_try.localdatabase.TaskData

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = Contract.TaskTbl.TABLE_NAME)
data class TaskData(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = Contract.TaskTbl.NAME) val TiteTask: String,
    @ColumnInfo(name =  Contract.TaskTbl.DATE) val DateTask: String,
    @ColumnInfo(name = Contract.TaskTbl.DESCRIPTION) val TaskDescription: String
)