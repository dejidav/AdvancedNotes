package e.dav.advancednotes;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import java.util.ArrayList;
import java.util.List;

import e.dav.advancednotes.db.DbHelper;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button newNote, dispNotes;
    ListView nListView;
    DbHelper db;
    NoteAdapter nAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        newNote =(Button) findViewById(R.id.btn_newNote);
        nListView = findViewById(R.id.list_notes);
        dispNotes = findViewById(R.id.btn_dispNotes);
        db = new DbHelper(this);
        dispNotes = (Button)findViewById(R.id.btn_dispNotes);

        newNote.setOnClickListener(this);
        dispNotes.setOnClickListener(this);

        populateListView();



    }

    public void populateListView(){
        //get the data and append to list


        ArrayList<Note> data = db.getNotes();
        nAdapter = new NoteAdapter(this, data);




    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_newNote:
                Intent intent = new Intent(MainActivity.this, NoteActivity.class);
                startActivity(intent);

            break;

            case R.id.btn_dispNotes:
                populateListView();
            break;
        }
    }


}
