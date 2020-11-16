package com.example.mynote

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface NoteDao {

    @Insert
    fun insert(note: Note)

    @Update
    fun update(note: Note)

    @Delete
    fun delete(note: Note)

    @Query("Delete from tblNotes")
    fun deleteAllNotes()

    @Query("SELECT * FROM tblNotes ORDER BY priority DESC")
    fun getAllNote() : LiveData<List<Note>>

}