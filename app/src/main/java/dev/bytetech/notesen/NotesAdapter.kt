package dev.bytetech.notesen

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NotesAdapter(private var notes: List<Note>, context: Context):
    RecyclerView.Adapter<NotesAdapter.NoteViewHolder>() {
    class NoteViewHolder(itemVeiw: View): RecyclerView.ViewHolder(itemVeiw){
        val titleTextView: TextView = itemVeiw.findViewById(R.id.titleText)
        val contentTextView: TextView = itemVeiw.findViewById(R.id.contentText)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.note_item, parent,false)
        return NoteViewHolder(view)
    }

    override fun getItemCount(): Int = notes.size

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val note = notes[position]
        holder.titleTextView.text = note.title
        holder.contentTextView.text = note.content
    }

    fun refreshData(newNotes: List<Note>){
        notes = newNotes
        notifyDataSetChanged()
    }

}