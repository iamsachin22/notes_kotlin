package com.sachin.notes

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NotesAdapter(private val context: Context, private val listner: InterfaceNotesAdapter) :
    RecyclerView.Adapter<NotesAdapter.NoteViewHolder>() {

    private val allNotes = ArrayList<Note>()


    inner class NoteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textView: TextView = itemView.findViewById(R.id.text)
        val deleteButton: ImageView = itemView.findViewById(R.id.deleteButton)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val viewHolder =
            NoteViewHolder(LayoutInflater.from(context).inflate(R.layout.item_note, parent, false))
        viewHolder.deleteButton.setOnClickListener {
            listner.onItemClicked(allNotes[viewHolder.adapterPosition])
        }
        return viewHolder
    }


    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val currentNote = allNotes[position]
        holder.textView.text = currentNote.text
    }

    fun updateList(newList: List<Note>) {
        allNotes.clear()
        allNotes.addAll(newList)

        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return allNotes.size
    }

    interface InterfaceNotesAdapter {
        fun onItemClicked(note: Note)
    }


}