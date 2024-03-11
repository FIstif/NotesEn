package dev.bytetech.notesen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import dev.bytetech.notesen.databinding.ActivityAddNoteBinding
import dev.bytetech.notesen.databinding.ActivityMainBinding
import kotlin.math.pow
import kotlin.math.sqrt

class AddNote : AppCompatActivity() {
    private lateinit var binds: ActivityAddNoteBinding
    private lateinit var db: NotesDatabaseHelper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binds = ActivityAddNoteBinding.inflate(layoutInflater)
        setContentView(binds.root)
        db = NotesDatabaseHelper(this)
        binds.saveButton.setOnClickListener {
            val title: String = binds.edinp.text.toString()
            val content = binds.editTextText.text.toString()
            val note = Note(0, title,content)
            db.insertNote(note)
            finish()
            Toast.makeText(this, "Note Saved", Toast.LENGTH_SHORT).show()
        }

    }

    private fun isFieldEmpty(): Boolean{
        binds.apply {
            if (edinp.text.isNullOrEmpty()) edinp.error = "Обязательное поле для заполнения."
            return edinp.text.isNullOrEmpty()
        }
    }
}