package com.example.notesapp;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "notes")
public class Notes {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String title;
    private String description;
    private int day;
    private int priority;

    public Notes(int id, String title, String description, int day, int priority) {
        this.id=id;
        this.title = title;
        this.description = description;
        this.day = day;
        this.priority = priority;
    }

    @Ignore
    public Notes(String title, String description, int day, int priority) {
        this.title = title;
        this.description = description;
        this.day = day;
        this.priority = priority;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getDay() {
        return day;
    }

    public int getPriority() {
        return priority;
    }

    public String getDayAsString(int day){
        switch (day){
            case 1:
                return "Понидельник";
            case 2:
                return "Вторник";
            case 3:
                return "Среда";
            case 4:
                return "Четверг";
            case 5:
                return "Пятница";
            case 6:
                return "Суббота";
            case 7:
                return "Воскресенье";
        }
        return null;
    }

}
