package e.dav.advancednotes.db;

import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import e.dav.advancednotes.Attachment;
import e.dav.advancednotes.Category;
import e.dav.advancednotes.Note;
import e.dav.advancednotes.utils.*;

import java.io.IOException;
import java.security.Security;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class DbHelper extends SQLiteOpenHelper {

    // Database name
    private static final String DATABASE_NAME = Constants.DATABASE_NAME;
    // Database version aligned if possible to software version
    private static final int DATABASE_VERSION = 1;
    // Sql query file directory
    private static final String SQL_DIR = "sql";

    // Notes table name
    public static final String TABLE_NOTES = "notes_db";
    // Notes table columns
    public static final String KEY_CREATION = "creation";
    public static final String KEY_TITLE = "title";
    public static final String KEY_CONTENT = "content";
    public static final String KEY_CATEGORY = "category_id";




    // Queries
    private static final String CREATE_QUERY = "-- Create table for NOTES\n" +
            "CREATE TABLE IF NOT EXISTS "+ TABLE_NOTES +
            " ( _id INTEGER PRIMARY KEY AUTOINCREMENT," +
            " creation INTEGER," +
            " title TEXT," +
            " content TEXT," +
            " category_id INTEGER DEFAULT null" +
            " );";



    private final Context mContext;
    private final SharedPreferences prefs;

    private static DbHelper instance = null;
    private SQLiteDatabase db;



    public DbHelper(Context mContext) {
        super(mContext, DATABASE_NAME, null, DATABASE_VERSION);
        this.mContext = mContext;
        this.prefs = mContext.getSharedPreferences(Constants.PREFS_NAME, Context.MODE_MULTI_PROCESS);
    }


    public String getDatabaseName() {
        return DATABASE_NAME;
    }

    public SQLiteDatabase getDatabase() {
        return getDatabase(false);
    }


    public SQLiteDatabase getDatabase(boolean forceWritable) {
        try {
            SQLiteDatabase db = getReadableDatabase();
            if (db.isReadOnly() && forceWritable) {
                db = getWritableDatabase();
            }
            return db;
        } catch (IllegalStateException e) {
            return this.db;
        }
    }


    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
            Log.i("createdb", "Database creation");
            db.execSQL(CREATE_QUERY);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS notes");
        onCreate(db);


    }



    // Inserting or updating single note
    public void insertNote(Note note) {
        SQLiteDatabase db = getWritableDatabase();


        ContentValues values = new ContentValues();
        values.put(KEY_CREATION, note.getCreation() != null ? note.getCreation() : Calendar.getInstance()
                .getTimeInMillis());
        values.put(KEY_TITLE, note.getTitle());
        values.put(KEY_CONTENT, note.getContent());
        values.put(KEY_CATEGORY, note.getCategory() != null ? note.getCategory().getId() : null);

        db.insert(TABLE_NOTES, KEY_CREATION, values);

       // db.insertWithOnConflict(TABLE_NOTES, KEY_ID, values, SQLiteDatabase.CONFLICT_REPLACE);
        Log.d("DBHelper", "Updated note titled '" + note.getTitle() + "'");


        // Fill the note with correct data before returning it



    }

    // get list of all notes

    public ArrayList<Note> getNotes() {
        ArrayList<Note> noteList = new ArrayList<>();
        // Generic query to be specialized with conditions passed as parameter
        String query = "SELECT * FROM " + TABLE_NOTES + ";";
        Cursor cursor=null;
        try{
            cursor = getDatabase().rawQuery(query, null);

            // Looping through all rows and adding to list
            if (cursor.moveToFirst()) {
                do {
                    int i = 0;
                    Note note = new Note();
                    note.setCreation(cursor.getLong(i++));
                    note.setTitle(cursor.getString(i++));
                    note.setContent(cursor.getString(i++));
                    Long categoryId = cursor.getLong(i++);
                    if (categoryId != 0) {
                        Category category = new Category(categoryId, cursor.getString(i++),
                                cursor.getString(i++), cursor.getString(i++));
                        note.setCategory(category);
                    }
                    // Adding note to list
                    noteList.add(note);


                } while (cursor.moveToNext());


            }

        } finally {
            if (cursor != null)
                cursor.close();
        }


        return noteList;
    }
}




