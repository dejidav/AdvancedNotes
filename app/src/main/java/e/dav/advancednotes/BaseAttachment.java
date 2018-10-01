package e.dav.advancednotes;

import java.util.Calendar;


public class BaseAttachment {

    private Long id;
    private String uriPath;
    private String name;
    private long size;
    private long length;
    private String mime_type;


    public BaseAttachment() {
        this.id = Calendar.getInstance().getTimeInMillis();}


    public BaseAttachment(String uri, String mime_type) {
        this.id = Calendar.getInstance().getTimeInMillis();
        this.uriPath = uri;
        this.setMime_type(mime_type);
    }


    public BaseAttachment(Long id, String uri, String name, long size, long length, String mime_type) {
        this.id = id;
        this.uriPath = uri;
        this.name = name;
        this.size = size;
        this.length = length;
        this.setMime_type(mime_type);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUriPath() {
        return uriPath;
    }

    public void setUriPath(String uriPath) {
        this.uriPath = uriPath;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public long getLength() {
        return length;
    }

    public void setLength(long length) {
        this.length = length;
    }

    public String getMime_type() {
        return mime_type;
    }

    public void setMime_type(String mime_type) {
        this.mime_type = mime_type;
    }
}
