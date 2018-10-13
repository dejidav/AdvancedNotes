package e.dav.advancednotes;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class NoteAdapter extends ArrayAdapter<Note> {

    private Context mContext;
    private List<Note> noteList = new ArrayList<>();

    public NoteAdapter(@NonNull Context context, @SuppressLint("SupportAnnotationUsage") @LayoutRes ArrayList<Note> list) {
        super(context, 0, list);
        mContext = context;
        noteList = list;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItem = convertView;
        if (listItem == null)
            listItem = LayoutInflater.from(mContext).inflate(R.layout.row_layout, parent, false);

        Note currentNote = noteList.get(position);
        TextView title = listItem.findViewById(R.id.noteTitle_view);
        title.setText(currentNote.getTitle());

        TextView content = listItem.findViewById(R.id.noteContent_view);
        content.setText(currentNote.getContent());

        TextView creation = listItem.findViewById(R.id.noteCreationDate_view);
        creation.setText(currentNote.getCreation().toString());

        TextView category = listItem.findViewById(R.id.category_view);
        category.setText(currentNote.getCategoryid().toString());

        return listItem;

    }
}
