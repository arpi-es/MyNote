package com.example.mynote

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class NoteAdapter : RecyclerView.Adapter<NoteAdapter.NoteAdapterHolder>() {


    private val notes : List<Note?> = ArrayList<Note>()




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteAdapterHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.note_item, parent, false)
        return NoteAdapterHolder(view)
    }

    override fun onBindViewHolder(holder: NoteAdapterHolder, position: Int) {

    }

    override fun getItemCount(): Int {
        return  notes.size
    }


    class NoteAdapterHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

    }



}