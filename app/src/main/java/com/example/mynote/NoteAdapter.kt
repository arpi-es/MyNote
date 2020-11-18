package com.example.mynote

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.note_item.view.*

class NoteAdapter : RecyclerView.Adapter<NoteAdapter.NoteAdapterHolder>()  {

    var notes: List<Note?> = ArrayList<Note>()
    private var listener: OnItemClickListener? = null


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteAdapterHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.note_item, parent, false)
        return NoteAdapterHolder(view)
    }

    override fun onBindViewHolder(holder: NoteAdapterHolder, position: Int) {
//        val currentNote: Note = getItem(position)
        val currentNote: Note = notes[position]!!
        holder.txtViewTitle.text = currentNote.title
        holder.txtViewDescription.text = currentNote.description
        holder.txtViewPriority.text = currentNote.priority.toString()
    }

    override fun getItemCount(): Int {
        return  notes.size
    }

    fun getNoteAt(position: Int): Note {
        return notes[position]!!
    }

    inner class NoteAdapterHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        init {
            itemView.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    listener?.onItemClick(getNoteAt(position))
                }
            }
        }



        var txtViewTitle: TextView = itemView.txt_title
        var txtViewPriority: TextView = itemView.txt_priority
        var txtViewDescription: TextView = itemView.txt_description




    }

    fun setOnItemClickListener(listener: OnItemClickListener){
        this.listener = listener
    }



}