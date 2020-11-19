package com.example.mynote.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.mynote.service.model.Note
import com.example.mynote.service.repository.NoteRepository

class MainViewModel(application: Application) : AndroidViewModel(application) {

    val repository : NoteRepository = NoteRepository(application)

    private var allNotes : LiveData<List<Note>> = repository.getAllNotes()

    fun insert(note: Note) {
        repository.insertNote(note)
    }

    fun update(note: Note) {
        repository.update(note)
    }

    fun delete(note: Note) {
        repository.delete(note)
    }

    fun deleteAllNotes() {
        repository.deleteAllNotes()
    }

    fun getAllNotes(): LiveData<List<Note>> {
        return allNotes
    }


}