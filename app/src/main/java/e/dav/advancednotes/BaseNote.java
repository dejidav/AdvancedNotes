package e.dav.advancednotes;

import android.os.Parcel;
import android.os.Parcelable;

public class BaseNote {

    //declaring variables
    private Long creation;
    private Long lastModification;
    private String title;
    private String content;
    private Integer archived;
    private Integer trashed;
    private String alarm;
    private String recurrenceRule;
    private Integer reminderFired;
    private String latitude;
    private String longitude;
    private String address;
    private Category category;
    private Integer locked;
    private Integer checklist;




    public BaseNote(){


    }

    public BaseNote(Long creation, Long lastModification, String title, String content, Integer archived,
                    Integer trashed, String alarm, String recurrenceRule, Integer reminderFired, String latitude, String longitude, String address, Category
                            category, Integer locked, Integer checklist){

        this.creation = creation;
        this.lastModification = lastModification;
        this.title = title;
        this.content = content;
        this.archived = archived;
        this.trashed = trashed;
        this.alarm = alarm;
        this.recurrenceRule = recurrenceRule;
        this.reminderFired = reminderFired;
        this.latitude = latitude;
        this.longitude = longitude;
        this.address = address;
        this.category = category;
        this.locked = locked;
        this.checklist = checklist;



    }

    public BaseNote(Note note){

    }


    public Long getCreation() {
        return creation;
    }

    public void setCreation(Long creation) {
        this.creation = creation;
    }

    public Long getLastModification() {
        return lastModification;
    }

    public void setLastModification(Long lastModification) {
        this.lastModification = lastModification;
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

    public Integer getArchived() {
        return archived;
    }

    public void setArchived(Integer archived) {
        this.archived = archived;
    }

    public Integer getTrashed() {
        return trashed;
    }

    public void setTrashed(Integer trashed) {
        this.trashed = trashed;
    }

    public String getAlarm() {
        return alarm;
    }

    public void setAlarm(String alarm) {
        this.alarm = alarm;
    }

    public String getRecurrenceRule() {
        return recurrenceRule;
    }

    public void setRecurrenceRule(String recurrenceRule) {
        this.recurrenceRule = recurrenceRule;
    }

    public Integer getReminderFired() {
        return reminderFired;
    }

    public void setReminderFired(Integer reminderFired) {
        this.reminderFired = reminderFired;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Integer getLocked() {
        return locked;
    }

    public void setLocked(Integer locked) {
        this.locked = locked;
    }

    public Integer getChecklist() {
        return checklist;
    }

    public void setChecklist(Integer checklist) {
        this.checklist = checklist;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
