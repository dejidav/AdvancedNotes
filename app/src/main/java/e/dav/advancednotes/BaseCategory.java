package e.dav.advancednotes;

import java.util.Calendar;

public class BaseCategory {

    private Long id;
    private String name;
    private String color;
    private String description;
    private String title;
    private int count;

    public BaseCategory(){
        this.id = Calendar.getInstance().getTimeInMillis();
    }


    public BaseCategory(BaseCategory baseCategory) {
        this(baseCategory.getId(), baseCategory.getName(), baseCategory.getDescription(), baseCategory.getColor());
    }


    public BaseCategory(Long id, String title, String description, String color) {
        this(id, title, description, color, 0);
    }


    public BaseCategory(Long id, String title, String description, String color, int count){
        this.id = id;
        this.title = title;
        this.description = description;
        this.color = color;
        this.count = count;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public int getCount() {
        return count;
    }

    public String getTitle() {
        return title;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public boolean equals(Object obj) {
        boolean result = false;
        if (obj != null && obj.getClass().equals(this.getClass())) {
            try {
                BaseCategory c = (BaseCategory) obj;
                result = (getColor() == c.getColor() || getColor().equals(c.getColor()))
                        &&  (getDescription() == c.getDescription() || getDescription().equals(c.getDescription()))
                        &&  (getName() == c.getName() || getName().equals(c.getName()))
                        &&  (getId() == c.getId() || getId().equals(c.getId()));
            } catch (ClassCastException e) {
                result = false;
            }
        }
        return result;
    }
}
