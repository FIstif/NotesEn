package dev.bytetech.notesen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import dev.bytetech.notesen.databinding.ActivityUpdateBinding

class UpdateActivity : AppCompatActivity() {
    private lateinit var binds: ActivityUpdateBinding
    private lateinit var db: NotesDatabaseHelper
    private var noteId: Int = -1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binds = ActivityUpdateBinding.inflate(layoutInflater)
        setContentView(binds.root)

        db = NotesDatabaseHelper(this)

        noteId = intent.getIntExtra("note_id", -1)
        if (noteId == -1){
            finish()
            return
        }

        val note = db.getById(noteId)
        binds.updateTextBody.setText(note.content)

        binds.editButton.setOnClickListener {
            val newTitle = binds.UpdateText.toString()
            val newcontent = binds.updateTextBody.text.toString()
            val updateNote = Note(noteId, newTitle, newcontent)
            db.updateNote(updateNote)
            finish()
            Toast.makeText(this, "Changes Saved", Toast.LENGTH_SHORT).show()
        }
    }
}