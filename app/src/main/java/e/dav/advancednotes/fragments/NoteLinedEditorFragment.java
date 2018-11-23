package e.dav.advancednotes.fragments;

import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import e.dav.advancednotes.MainActivity;
import e.dav.advancednotes.R;
import e.dav.advancednotes.db.NoteManager;
import e.dav.advancednotes.model.Note;

import static android.app.Activity.RESULT_OK;

public class NoteLinedEditorFragment extends Fragment {

    private View mRootView;
    private EditText mTitleEditText;
    private EditText mContentEditText;
    private Note mCurrentNote = null;
    private int tag = 0;
    private static final int PICKFILE_RESULT_CODE = 1;

    public NoteLinedEditorFragment() {
        // Required empty public constructor
    }

    public static NoteLinedEditorFragment newInstance(int id){
        NoteLinedEditorFragment fragment = new NoteLinedEditorFragment();

        if (id > 0){
            Bundle bundle = new Bundle();
            bundle.putInt("id", id);
            fragment.setArguments(bundle);
        }
        return fragment;
    }

    private void getCurrentNote(){
        Bundle args = getArguments();
        if (args != null && args.containsKey("id")){
            int id = args.getInt("id", 0);
            if (id > 0){
                mCurrentNote = NoteManager.newInstance(getActivity()).getNote(id);
            }
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
        getCurrentNote();
    }



    @Override
    public void onResume() {
        super.onResume();
        if (mCurrentNote != null){
            populateFields();
        }
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        menu.clear();
        inflater.inflate(R.menu.menu_note_edit_plain, menu);
    }

    //@TargetApi(Build.VERSION_CODES.KITKAT)
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_delete:
                //delete note

                if (mCurrentNote != null){
                    promptForDelete();
                }else {
                    makeToast("Cannot delete note that has not been saved");
                }
                return true;

            case R.id.action_save:
                //save notes
                if (saveNote()){

                    makeToast(mCurrentNote !=  null ? "Note updated" : "Note saved");
                }
                return true;

            case R.id.action_attach:
                //attach files
                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("*/*");
                String[] mimetypes = {"image/*", "video/*", "application/*"};
                intent.putExtra(Intent.EXTRA_MIME_TYPES, mimetypes);
                startActivityForResult(intent,PICKFILE_RESULT_CODE);

                return true;

            //remember: download color drawables for tags
            case R.id.tag_red:
                tag = 1;
                return true;

            case R.id.tag_yellow:
                tag = 2;
                return true;

            case R.id.tag_blue:
                tag = 3;
                return true;

            case R.id.tag_green:
                tag = 4;
                return true;

            case R.id.tag_orange:
                tag = 5;
                return true;


        }
        return super.onOptionsItemSelected(item);
    }



    private void populateFields() {
        mTitleEditText.setText(mCurrentNote.getTitle());
        mContentEditText.setText(mCurrentNote.getContent());
    }


    private boolean saveNote(){

        String title = mTitleEditText.getText().toString();
        if (TextUtils.isEmpty(title)){
            mTitleEditText.setError("Title is required");
            return false;
        }

        String content = mContentEditText.getText().toString();
        if (TextUtils.isEmpty(content)){
            mContentEditText.setError("Content is required");
            return false;
        }



        if (mCurrentNote != null){
            mCurrentNote.setContent(content);
            mCurrentNote.setTitle(title);
            NoteManager.newInstance(getActivity()).update(mCurrentNote);


        }else {
            Note note = new Note();
            note.setTitle(title);
            note.setContent(content);
            note.setTag(tag);

            NoteManager.newInstance(getActivity()).create(note);
        }
        return true;

    }

    private void makeToast(String message){
        Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
    }

    public void promptForDelete(){
        final String titleOfNoteTobeDeleted = mCurrentNote.getTitle();
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(getActivity());
        alertDialog.setTitle("Delete " + titleOfNoteTobeDeleted + " ?");
        alertDialog.setMessage("Are you sure you want to delete the note " + titleOfNoteTobeDeleted + "?");
        alertDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                NoteManager.newInstance(getActivity()).delete(mCurrentNote);
                makeToast(titleOfNoteTobeDeleted + "deleted");
                startActivity(new Intent(getActivity(), MainActivity.class));
            }
        });
        alertDialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        alertDialog.show();
    }



    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mRootView =inflater.inflate(R.layout.fragment_note_lined_editor, container, false);
        mTitleEditText = mRootView.findViewById(R.id.edit_text_title);
        mContentEditText = mRootView.findViewById(R.id.edit_text_note);
        return mRootView;
    }


    //  create view for attachment
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        // TODO Auto-generated method stub
        switch (requestCode) {
            case PICKFILE_RESULT_CODE:
                if (resultCode == RESULT_OK) {
                    String filePath = data.getData().getPath();
                    mCurrentNote.setAttachment(filePath);
                }
                makeToast("File Attached");
                break;

        }
    }


}