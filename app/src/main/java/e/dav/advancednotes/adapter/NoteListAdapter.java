package e.dav.advancednotes.adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import e.dav.advancednotes.R;
import e.dav.advancednotes.model.Note;

public class NoteListAdapter extends RecyclerView.Adapter<NoteListAdapter.ViewHolder>{

    private List<Note> mNotes;
    private Context mContext;
    private ItemClickListener itemClickListener;



    //constructor
    public NoteListAdapter(List<Note> notes, Context context){
        mNotes = notes;
        mContext = context;
        this.itemClickListener = itemClickListener;

    }




    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View rowView = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_note_list, parent, false);
        ViewHolder viewHolder = new ViewHolder(rowView);
        return viewHolder;
    }


    //HERE you bind one item of your list to the view holder
    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element

        //final Note mnote = mNotes.get((position));
        holder.noteTitle.setText(mNotes.get((position)).getTitle());
        holder.noteCreateDate.setText(mNotes.get((position)).getReadableModifiedDate());
/*
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                itemClickListener.onItemClicked(holder, mnote, position);
            }
        });*/



    }

    @Override
    public int getItemCount() {
        return mNotes.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        public final TextView noteTitle, noteCreateDate;



        public ViewHolder(View itemView) {
            super(itemView);
            noteTitle = itemView.findViewById(R.id.text_view_note_title);
            noteCreateDate = itemView.findViewById(R.id.text_view_note_date);
        }



    }


    public void promptForDelete(final int position){
        String fieldToBeDeleted = mNotes.get(position).getTitle();
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(mContext);
        alertDialog.setTitle("Delete " + fieldToBeDeleted + " ?");
        alertDialog.setMessage("Are you sure you want to delete the note " + fieldToBeDeleted + "?");
        alertDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                mNotes.remove(position);
                notifyItemRemoved(position);
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


}
