package e.dav.advancednotes;

import android.os.Parcel;
import android.os.Parcelable;



public class Category extends BaseCategory {




    public Category() {
        super();
    }


    public Category(BaseCategory category) {
        super(category.getId(), category.getName(), category.getDescription(), category.getColor());
    }


    public Category(Long id, String title, String description, String color) {
        super(id, title, description, color);
    }


    public Category(Long id, String title, String description, String color, int count) {
        super(id, title, description, color, count);
    }



}

