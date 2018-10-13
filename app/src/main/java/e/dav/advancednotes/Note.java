package e.dav.advancednotes;

import android.os.Parcel;
import android.os.Parcelable;


public class Note extends BaseNote  {




    public Note() {
        super();
    }


    public Note(Long creation, String title, String content,  Category category) {
        super(creation,  title, content,  category);
    }


    public Note(Note note) {
        super(note);

    }




    @Override
    public Category getCategory() {
        try {
            return (Category) super.getCategory();
        } catch (ClassCastException e) {
            return new Category(super.getCategory());
        }
    }


    public void setCategory(Category category) {
        if (category != null && category.getClass().equals(BaseCategory.class)) {
            setCategory(new Category(category));
        }
        super.setCategory(category);
    }



}

