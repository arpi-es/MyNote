package com.example.mynote

import android.app.Application
import androidx.lifecycle.LiveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NoteRepository(application: Application){

    var noteDao : NoteDao

    private var allNotes : LiveData<List<Note>>
    init {
        val database : NoteDatabase = NoteDatabase.getInstance(application.applicationContext)!!
        noteDao = database.noteDao()
        allNotes = noteDao.getAllNote()
    }


    fun insertNote(note:Note){
        CoroutineScope(Dispatchers.IO).launch {
            noteDao.insert(note)
        }
    }

    fun update(note: Note) {
        CoroutineScope(Dispatchers.IO).launch {
            noteDao.update(note)
        }
    }

    fun delete(note: Note) {
        CoroutineScope(Dispatchers.IO).launch {
            noteDao.delete(note)
        }
    }

    fun deleteAllNotes() {
        CoroutineScope(Dispatchers.IO).launch {
            noteDao.deleteAllNotes()
        }

    }

    fun getAllNotes(): LiveData<List<Note>> {
        return allNotes
    }


}