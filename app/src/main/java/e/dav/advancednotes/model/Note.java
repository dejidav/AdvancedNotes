package e.dav.advancednotes.model;

import android.database.Cursor;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

import e.dav.advancednotes.utils.Constants;

public class Note {
    private int id;
    private String title;
    private String content;
    private Calendar dateCreated;
    private Calendar dateModified;
    private int tag;
    private String attachment;

    public Note(int id, String title, String content, Calendar dateCreated, Calendar dateModified, int tag, String attachment){
        this.id = id;
        this.title = title;
        this.content = content;
        this.dateCreated = dateCreated;
        this.dateModified = dateModified;
        this.tag = tag;
        this.attachment = attachment;
    }

    public Note(){

    }


    public static Note getNotefromCursor(Cursor cursor){
        Note note = new Note();
        note.setId(cursor.getInt(cursor.getColumnIndex(Constants.COLUMN_ID)));
        note.setTitle(cursor.getString(cursor.getColumnIndex(Constants.COLUMN_TITLE)));
        note.setContent(cursor.getString(cursor.getColumnIndex(Constants.COLUMN_CONTENT)));

        //get Calendar instance
        Calendar calendar = GregorianCalendar.getInstance();

        //set the calendar time to date created
        calendar.setTimeInMillis(cursor.getLong(cursor.getColumnIndex(Constants.COLUMN_CREATED_TIME)));
        note.setDateCreated(calendar);

        //set the calendar time to date modified
        calendar.setTimeInMillis(cursor.getLong(cursor.getColumnIndex(Constants.COLUMN_MODIFIED_TIME)));
        note.setDateModified(calendar);
        return note;
    }

    public String getReadableModifiedDate(){
        SimpleDateFormat sdf = new SimpleDateFormat("MMM dd, yyyy - h:mm a", Locale.getDefault());
        sdf.setTimeZone(getDateModified().getTimeZone());
        Date modifiedDate = getDateModified().getTime();
        return sdf.format(modifiedDate);
    }






    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Calendar getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Calendar dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Calendar getDateModified() {
        return dateModified;
    }

    public void setDateModified(Calendar dateModified) {
        this.dateModified = dateModified;
    }

    public int getTag() {
        return tag;
    }

    public void setTag(int tag) {
        this.tag = tag;
    }

    public String getAttachment() {
        return attachment;
    }

    public void setAttachment(String attachment) {
        this.attachment = attachment;
    }
}
