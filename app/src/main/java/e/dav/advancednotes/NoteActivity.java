package e.dav.advancednotes;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Calendar;

import e.dav.advancednotes.db.DbHelper;

public class NoteActivity extends AppCompatActivity {

    EditText noteTitle;
    EditText noteContent;
    Button saveNote;
    Button deleteNote;
    DbHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.note_layout);
        noteTitle = findViewById(R.id.edit_title);
        noteContent = findViewById(R.id.edit_notecontent);
        saveNote = findViewById(R.id.btn_save);
        deleteNote = findViewById(R.id.btn_delete);
        db = new DbHelper(this);


    }


    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_save:
                Note newNote = new Note();
                newNote.setTitle(noteTitle.getText().toString());
                newNote.setContent(noteContent.getText().toString());
                newNote.setCreation(Calendar.getInstance()
                        .getTimeInMillis());
                db.insertNote(newNote);


            break;

            case R.id.btn_delete:
            break;

        }
    }



}
