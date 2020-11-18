package com.example.mynote

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_add_note.*
import kotlinx.android.synthetic.main.note_item.*

class AddEditNoteActivity : AppCompatActivity() {

    private lateinit var mainViewModel: MainViewModel

    companion object {
        const val EXTRA_ID = "com.example.mynote.EXTRA_ID"
        const val EXTRA_TITLE = "com.example.mynote.EXTRA_TITLE"
        const val EXTRA_DESCRIPTION = "ccom.example.mynote.EXTRA_DESCRIPTION"
        const val EXTRA_PRIORITY = "com.example.mynote.EXTRA_PRIORITY"
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_note)

        numpicker_priority.minValue = 1
        numpicker_priority.maxValue = 10
        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_close)

        if (intent.hasExtra(EXTRA_ID)) {
            title = "Edit Note"
            edtTitle.setText(intent.getStringExtra(EXTRA_TITLE))
            edtDescription.setText(intent.getStringExtra(EXTRA_DESCRIPTION))
            numpicker_priority.value = intent.getIntExtra(EXTRA_PRIORITY, 1)
        } else {
            title = "Add Note"
        }


    }

    private fun saveNote() {

        if (edtTitle.text.toString().trim().isBlank() || edtDescription.text.toString().trim()
                .isBlank()
        ) {
            Toast.makeText(this, "Can not insert empty note!", Toast.LENGTH_SHORT).show()
            return
        }

        val title: String = edtTitle.text.toString()
        val desc: String = edtDescription.text.toString()
        val priority: Int = numpicker_priority.value


        if (intent.hasExtra(EXTRA_ID)) {
            val note = Note(title, desc, priority)
            val id = intent?.getIntExtra(AddEditNoteActivity.EXTRA_ID, -1)
            if (id != -1) {
                note.id = intent.getIntExtra(AddEditNoteActivity.EXTRA_ID, -1)
                mainViewModel.update(note)
            }


        } else {
            val note: Note = Note(title, desc, priority)
            mainViewModel.insert(note)
        }

        finish()

    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.addnote_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        return when (item.itemId) {
            R.id.save_note -> {
                saveNote()
                true


            }

            else -> super.onOptionsItemSelected(item)


        }

    }


}