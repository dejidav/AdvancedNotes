package e.dav.advancednotes.utils;

public interface Constants {

    public static final String NOTES_TABLE = "AdvNotes";

    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_TITLE = "title";
    public static final String COLUMN_CONTENT = "content";
    public static final String COLUMN_MODIFIED_TIME = "date_modified";
    public static final String COLUMN_CREATED_TIME = "date_created";
    public static final String COLUMN_TAG = "tag";
    public static final String COLUMN_ATTACHMENT = "attachment";



    public static final String[] COLUMNS = {
            Constants.COLUMN_ID,
            Constants.COLUMN_TITLE,
            Constants.COLUMN_CONTENT,
            Constants.COLUMN_CREATED_TIME,
            Constants.COLUMN_MODIFIED_TIME,
            Constants.COLUMN_TAG,
            Constants.COLUMN_ATTACHMENT
    };
}