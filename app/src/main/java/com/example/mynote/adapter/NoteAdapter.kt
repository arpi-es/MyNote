package com.example.mynote.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.mynote.ui.OnItemClickListener
import com.example.mynote.R
import com.example.mynote.data.Note
import com.example.mynote.databinding.NoteItemBinding

class NoteAdapter : RecyclerView.Adapter<NoteAdapter.NoteAdapterHolder>()  {

    var notes: List<Note?> = ArrayList<Note>()
    private var listener: OnItemClickListener? = null


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteAdapterHolder {
//        val inflater = LayoutInflater.from(parent.context)
//        val view = inflater.inflate(R.layout.note_item, parent, false)
//        return NoteAdapterHolder(view)


        val binding = DataBindingUtil.inflate<NoteItemBinding>(LayoutInflater.from(parent.context),
            R.layout.note_item, parent, false)
        return NoteAdapterHolder(binding)


    }

    override fun onBindViewHolder(holder: NoteAdapterHolder, position: Int) {
//        val currentNote: Note = getItem(position)
        val currentNote: Note = notes[position]!!


        holder.binding.note = currentNote
        holder.binding.executePendingBindings()

//        holder.txtViewTitle.text = currentNote.title
//        holder.txtViewDescription.text = currentNote.description
//        holder.txtViewPriority.text = currentNote.priority.toString()
    }

    override fun getItemCount(): Int {
        return  notes.size
    }

    fun getNoteAt(position: Int): Note {
        return notes[position]!!
    }

    inner class NoteAdapterHolder(val binding : NoteItemBinding) : RecyclerView.ViewHolder(binding.root){

        init {
            itemView.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    listener?.onItemClick(getNoteAt(position))
                }
            }
        }



//        var txtViewTitle: TextView = itemView.txt_title
//        var txtViewPriority: TextView = itemView.txt_priority
//        var txtViewDescription: TextView = itemView.txt_description




    }

    fun setOnItemClickListener(listener: OnItemClickListener){
        this.listener = listener
    }



}