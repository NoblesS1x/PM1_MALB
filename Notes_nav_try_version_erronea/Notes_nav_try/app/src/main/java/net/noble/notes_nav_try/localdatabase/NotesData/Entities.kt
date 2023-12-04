package net.noble.notes_nav_try.localdatabase.NotesData

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import net.noble.notes_nav_try.localdatabase.NotesData.Contract

@Entity(tableName = Contract.NotesTbl.TABLE_NAME)
data class NotesData(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = Contract.NotesTbl.NAME) val TiteNote: String,
    //@ColumnInfo(name = Contract.NotesTbl.DATE) val DateNote: LocalDate,
    @ColumnInfo(name = Contract.NotesTbl.DATE) val DateNote: String,
    @ColumnInfo(name = Contract.NotesTbl.DESCRIPTION) val NoteDescription: String
)
