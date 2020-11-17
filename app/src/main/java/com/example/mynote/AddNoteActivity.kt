package com.example.mynote

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_add_note.*
import kotlinx.android.synthetic.main.note_item.*

class AddNoteActivity : AppCompatActivity() {

    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_note)

        numpicker_priority.minValue = 1
        numpicker_priority.maxValue = 10

        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_close)

        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)


    }



    private fun saveNote() {


        if (edtTitle.text.toString().trim().isBlank() || edtDescription.text.toString().trim().isBlank()) {
            Toast.makeText(this, "Can not insert empty note!", Toast.LENGTH_SHORT).show()
            return
        }


        val title :String = edtTitle.text.toString()
        val desc :String = edtDescription.text.toString()
        val priority : Int = numpicker_priority.value

       val note : Note = Note( title, desc , priority)
        mainViewModel.insert(note)


        finish()


    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.addnote_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        return when( item.itemId) {
             R.id.save_note -> {
                 saveNote()
                   true


             }

            else -> super.onOptionsItemSelected(item)


        }

    }



}