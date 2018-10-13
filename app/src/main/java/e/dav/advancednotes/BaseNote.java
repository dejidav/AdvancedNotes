package e.dav.advancednotes;


import java.util.ArrayList;
import java.util.List;

public class BaseNote {

    //declaring variables
    private String title;
    private String content;
    private Long creation;
    private BaseCategory baseCategory;


    public BaseNote() {
        super();
        this.title = "";
        this.content = "";


    }

    public BaseNote(Long creation,  String title, String content, BaseCategory
                            baseCategory){

        super();
        this.creation = creation;
        this.title = title;
        this.content = content;
        this.baseCategory = baseCategory;




    }

    public BaseNote(BaseNote baseNote){
        super();
        buildFromNote(baseNote);
    }

    private void buildFromNote(BaseNote baseNote) {

    }



    public Long getCreation() {
        return creation;
    }

    public void setCreation(Long creation) {
        this.creation = creation;
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


    public BaseCategory getCategory() {
        return baseCategory;
    }

    public Long getCategoryid() {
        return baseCategory.getId();
    }


    public void setCategory(BaseCategory baseCategory) {
        this.baseCategory = baseCategory;
    }

    }


    //maybe include a backup attachment function


    //figure out the equals function

