package e.dav.advancednotes;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;

import java.util.Calendar;

public class Attachment extends BaseAttachment  {

    private Uri uri;


    public Attachment(Uri uri, String mime_type) {
        this(Calendar.getInstance().getTimeInMillis(), uri, null, 0, 0, mime_type);
    }


    public Attachment(long id, Uri uri, String name, long size, long length, String mime_type) {
        super(id, uri != null ? uri.getPath() : null, name, size, length, mime_type);
        setUri(uri);
    }


    public Attachment(BaseAttachment attachment) {
        super(attachment.getId(), attachment.getUriPath(), attachment.getName(), attachment.getSize(), attachment
                .getLength(), attachment.getMime_type());
        this.uri = Uri.parse(attachment.getUriPath());
    }


    private Attachment(Parcel in) {
        setId(in.readLong());
        setUri(Uri.parse(in.readString()));
        setMime_type(in.readString());
    }


    public Uri getUri() {
        return uri;
    }


    public void setUri(Uri uri) {
        this.uri = uri;
        setUriPath(uri != null ? uri.toString() : "");
    }



}
