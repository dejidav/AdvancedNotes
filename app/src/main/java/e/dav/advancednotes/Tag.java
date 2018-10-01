package e.dav.advancednotes;

import android.os.Parcel;
import android.os.Parcelable;

public class Tag extends BaseTag implements Parcelable {

    private Tag(Parcel in) {
        setText(in.readString());
        setCount(in.readInt());
    }


    public Tag() {
        super();
    }


    public Tag(String text, Integer count) {
        super(text, count);
    }


    @Override
    public int describeContents() {
        return 0;
    }


    @Override
    public void writeToParcel(Parcel parcel, int flags) {
        parcel.writeString(getText());
        parcel.writeInt(getCount());
    }


    @Override
    public String toString() {
        return getText();
    }


    /*
     * Parcelable interface must also have a static field called CREATOR, which is an object implementing the
     * Parcelable.Creator interface. Used to un-marshal or de-serialize object from Parcel.
     */
    public static final Parcelable.Creator<Tag> CREATOR = new Parcelable.Creator<Tag>() {

        public Tag createFromParcel(Parcel in) {
            return new Tag(in);
        }


        public Tag[] newArray(int size) {
            return new Tag[size];
        }
    };
}

