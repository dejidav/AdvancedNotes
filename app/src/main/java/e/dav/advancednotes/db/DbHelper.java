package e.dav.advancednotes.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;
import android.util.Log;


public class DbHelper extends SQLiteOpenHelper {


    private static final String DATABASE_NAME = "advanced_note_app.db";
    private static final int DATABASE_VERSION = 2;

    public DbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + FeedEntry.TABLE_NAME + " ( " +
                    FeedEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    FeedEntry.COLUMN_NAME_TITLE + " TEXT, " +
                    FeedEntry.COLUMN_NAME_CONTENT + " TEXT, " +
                    FeedEntry.COLUMN_NAME_DATE_CREATED + " INTEGER, " +
                    FeedEntry.COLUMN_NAME_DATE_MODIFIED + " INTEGER, " +
                    FeedEntry.COLUMN_NAME_TAG + " INTEGER, " +
                    FeedEntry.COLUMN_NAME_ATTACHMENT + " TEXT)";


    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + FeedEntry.TABLE_NAME;




    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
        Log.e("create note db", "Note db created");
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }

    /* Inner class that defines the table contents */
    public static class FeedEntry implements BaseColumns {
        public static final String TABLE_NAME = "AdvNotes";
        public static final String COLUMN_NAME_TITLE = "title";
        public static final String COLUMN_NAME_CONTENT = "content";
        public static final String COLUMN_NAME_DATE_CREATED = "date_created";
        public static final String COLUMN_NAME_DATE_MODIFIED = "date_modified";
        public static final String COLUMN_NAME_TAG = "tag";
        public static final String COLUMN_NAME_ATTACHMENT = "attachment";

    }




}




