package com.example.mynote

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var mainViewModel : MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recycler_main.layoutManager = LinearLayoutManager(this)

        val adapter = NoteAdapter()

        recycler_main.adapter = adapter

        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        mainViewModel.getAllNotes().observe( this, Observer<List<Note>>{
            Log.i("THIS", it.size.toString())
            adapter.notes = it

        })








    }
}