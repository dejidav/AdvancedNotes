package e.dav.advancednotes;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import e.dav.advancednotes.adapter.NoteListAdapter;
import e.dav.advancednotes.db.DbHelper;
import e.dav.advancednotes.fragments.NoteListFragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button newNote, dispNotes;
    ListView nListView;
    DbHelper db;
    NoteListAdapter nAdapter;

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





    }



    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_newNote:
                Intent intent = new Intent(MainActivity.this, NoteActivity.class);
                startActivity(intent);

                break;

            case R.id.btn_dispNotes:
                openFragment(new NoteListFragment());
                break;
        }
    }


    private void openFragment(final Fragment fragment){
        getSupportFragmentManager()
                .beginTransaction()
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                .replace(R.id.container, fragment)
                .addToBackStack(null)
                .commit();

    }

}
